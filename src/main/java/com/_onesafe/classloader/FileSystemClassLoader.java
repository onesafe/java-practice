package com._onesafe.classloader;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> c = findLoadedClass(name);

        if (c != null) {
            return c;
        } else {
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }

            if (c != null) {
                return c;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(name, classData, 0, classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassData(String classname) {
        String path = rootDir + "/" + classname.replace(".", "/") + ".class";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            IOUtils.copy(new FileInputStream(path), baos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }


//        try (InputStream is = new FileInputStream(path)){
//
//            byte[] buffer = new byte[1024];
//            int temp = 0;
//            while((temp = is.read(buffer)) != -1) {
//                baos.write(buffer, 0, temp);
//            }
//            return baos.toByteArray();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
