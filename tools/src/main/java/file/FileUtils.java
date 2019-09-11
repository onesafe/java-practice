package file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import json.SerdesUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

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

    public static String readFileFromResource(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String content = reader.lines().collect(Collectors.joining("\n"));
        reader.close();
        return content;
    }


    // use guava
    public static String readFileFromResourceToString(String path) throws IOException {
        return Resources.toString(Resources.getResource(path), Charsets.UTF_8);
    }
}
