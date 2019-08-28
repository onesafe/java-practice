package json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by onesafe on 28/08/2019 4:49 PM.
 */
@Slf4j
public class SerdesUtils {

    private static final ObjectMapper OM = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static String serializeAsJsonString(Object object) {
        try {
            return OM.writeValueAsString(object);
        } catch (IOException e) {
            log.error("failed to serialize {} as json string", object, e);
            throw new RuntimeException("failed to serialize as json string", e);
        }
    }

    public static byte[] serializeAsJsonBytes(Object object) {
        try {
            return OM.writeValueAsBytes(object);
        } catch (IOException e) {
            log.error("failed to serialize {} as json bytes", object, e);
            throw new RuntimeException("failed to serialize as json bytes", e);
        }
    }

    public static <T> T deserialize(String json, Class<T> clazz) {
        try {
            return OM.readValue(json, clazz);
        } catch (IOException e) {
            log.error("failed to deserialize {} as instance of {}", json, clazz, e);
            throw new RuntimeException("failed to deserialize as " + clazz.getName(), e);
        }
    }

    public static <T> T deserialize(String json, TypeReference<T> tr) {
        try {
            return OM.readValue(json, tr);
        } catch (IOException e) {
            log.error("failed to deserialize {} as instance of {}", json, tr, e);
            throw new RuntimeException("failed to deserialize as " + tr.getType().getTypeName(), e);
        }
    }

    public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try {
            return OM.readValue(bytes, clazz);
        } catch (IOException e) {
            log.error("failed to deserialize {} as instance of {}", new String(bytes, UTF_8), clazz, e);
            throw new RuntimeException("failed to deserialize as " + clazz.getName(), e);
        }
    }

    public static <T> T deserialize(byte[] bytes, TypeReference<T> tr) {
        try {
            return OM.readValue(bytes, tr);
        } catch (IOException e) {
            log.error("failed to deserialize {} as instance of {}", new String(bytes, UTF_8), tr, e);
            throw new RuntimeException("failed to deserialize as " + tr.getType().getTypeName(), e);
        }
    }
}
