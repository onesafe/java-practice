package file;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by onesafe on 28/08/2019 5:06 PM.
 */
public class GzUtil {

    public static File gz(String filePath, String gzPath) throws Exception {
        if (filePath == null) {
            throw new IOException("src file not exist");
        }

        try (InputStream is = new FileInputStream(filePath);
             GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(gzPath))) {
            IOUtils.copy(is, gos);
            gos.finish();
            return new File(gzPath);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}
