package file;

import com.fasterxml.jackson.core.type.TypeReference;
import json.SerdesUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by onesafe on 28/08/2019 4:51 PM.
 */
public class FileUtils {

    public static String readContent(String fileName) throws Exception {
        return IOUtils.toString(new FileInputStream(fileName), UTF_8);
    }

    public static <T> T readContent(String fileName, Class<T> clazz) throws Exception {
        return SerdesUtils.deserialize(readContent(fileName), clazz);
    }

    public static <T> T readContent(String fileName, TypeReference<T> tr) throws Exception {
        return SerdesUtils.deserialize(readContent(fileName), tr);
    }
}
