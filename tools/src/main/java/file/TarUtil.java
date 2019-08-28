package file;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.file.Paths;

import static org.apache.commons.lang.SystemUtils.FILE_SEPARATOR;

/**
 * Created by onesafe on 28/08/2019 5:07 PM.
 */
public class TarUtil {

    private static final int BUF_LENGTH = 65536;

    public static String extractTar(InputStream is, String outputPath) throws Exception {
        File output = new File(outputPath);
        if (!output.exists() && !output.mkdirs()) throw new RuntimeException("failed to create dir " + outputPath);
        else if (!output.isDirectory()) throw new IllegalArgumentException("output must be a directory");
        try (TarArchiveInputStream tais = new TarArchiveInputStream(is)) {
            TarArchiveEntry tae;
            String folder = null;
            byte[] buf = new byte[BUF_LENGTH];
            while ((tae = tais.getNextTarEntry()) != null) {
                if (folder == null) folder = StringUtils.split(tae.getName(), FILE_SEPARATOR)[0];
                File file = new File(output.getAbsolutePath() + FILE_SEPARATOR + tae.getName());
                if (tae.isDirectory()) {
                    if (!file.exists() && !file.mkdirs()) throw new RuntimeException("failed to create sub dir " + file.getAbsolutePath());
                } else {
                    File parent = file.getParentFile();
                    if (!parent.exists() && !parent.mkdirs()) throw new RuntimeException("failed to create sub dir " + parent.getAbsolutePath());
                    try (OutputStream os = new FileOutputStream(file)) {
                        int size;
                        while ((size = tais.read(buf, 0, buf.length)) > 0) os.write(buf, 0, size);
                    }
                }
            }
            return folder;
        }
    }


    public static void compress(File[] files, String packagePath) throws IOException {
        try (ArchiveOutputStream tos = getArchiveOutputStream(packagePath)){
            for (File f : files) {
                if (f.isDirectory()) {
                    addDir(tos, f, null);
                } else {
                    addFile(tos, f, null);
                }
            }
        } catch (Exception e) {
            FileUtils.deleteQuietly(new File(packagePath));
            throw e;
        }
    }


    private static ArchiveOutputStream getArchiveOutputStream(String filePath) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(Paths.get(filePath).toAbsolutePath().normalize().toString());
        TarArchiveOutputStream stream = new TarArchiveOutputStream(outputStream);
        stream.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
        return stream;
    }


    private static void addDir(ArchiveOutputStream os, File file, String baseDir) throws IOException {
        String dir = file.getName() + File.separator;
        if (baseDir != null) {
            dir = baseDir + dir;
        }

        ArchiveEntry dirEntry = getArchiveEntry(dir, file);
        if(dirEntry != null) {
            os.putArchiveEntry(dirEntry);
        }

        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File f : listFiles) {
            if (f.isDirectory()) {
                addDir(os, f, dir);
            } else {
                addFile(os, f, dir);
            }
        }
    }


    private static void addFile(ArchiveOutputStream os, File file, String baseDir) throws IOException {
        BufferedInputStream bis = null;
        try {
            String path = file.getName();
            if (file.toString().endsWith(".sh")) {
                Boolean isExecute = file.setExecutable(true);
            }
            if (baseDir != null) {
                path = baseDir + path;
            }
            ArchiveEntry entry = getArchiveEntry(path, file);
            if(entry != null) {
                os.putArchiveEntry(entry);
            }

            bis = new BufferedInputStream(new FileInputStream(file.getAbsolutePath()));

            byte[] buffer = new byte[BUF_LENGTH];
            int read = -1;
            while((read = bis.read(buffer)) != -1) {
                os.write(buffer, 0, read);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (bis != null) {
                bis.close();
            }
            os.closeArchiveEntry();
        }
    }


    private static ArchiveEntry getArchiveEntry(String filePath, File file) {
        TarArchiveEntry entry = new TarArchiveEntry(filePath);
        if (file.toString().endsWith(".sh")) {
            int mask = 1 << 6;
            entry.setMode(entry.getMode() | mask);
        }
        entry.setSize(file.length());
        return entry;
    }

}
