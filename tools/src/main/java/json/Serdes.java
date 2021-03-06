package json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by onesafe on 17/10/11.
 */
public class Serdes {

    private static final ObjectMapper OM = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    public static String serializeAsJsonString(Object object) {
        CheckUtils.checkObjectsNotNull(object);
        try {
            return OM.writeValueAsString(object);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to serialize object to json", e);
        }
    }

    public static byte[] serializeAsJsonBytes(Object object) {
        CheckUtils.checkObjectsNotNull(object);
        try {
            return OM.writeValueAsBytes(object);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to serialize object to json", e);
        }
    }

    public static <T> T deserializeFromJson(String json, Class<T> clazz) {
        if (json == null) return null;
            try {
                return OM.readValue(json, clazz);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to deserialize from json " + json, e);
        }
    }

    public static <T> T deserializeFromJson(byte[] bytes, Class<T> clazz) {
        if (bytes == null) return null;
        try {
            return OM.readValue(bytes, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to deserialize from json bytes " + new String(bytes, UTF_8), e);
        }
    }

    public static <T> T deserializeFromJson(String json, TypeReference<T> tr) {
        if (json == null) return null;
        try {
            return OM.readValue(json, tr);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to deserialize from json " + json, e);
        }
    }

    public static <T> T deserializeFromJson(byte[] bytes, TypeReference<T> tr) {
        if (bytes == null) return null;
        try {
            return OM.readValue(bytes, tr);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to deserialize from json bytes " + new String(bytes, UTF_8), e);
        }
    }

    public static <T> T deserializeFromJson(String json, JavaType type) {
        if (json == null) return null;
        try {
            return OM.readValue(json, type);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to deserialize from json " + json, e);
        }
    }

    public static <T> T deserializeFromJson(byte[] bytes, JavaType type) {
        if (bytes == null) return null;
        try {
            return OM.readValue(bytes, type);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to deserialize from json bytes " + new String(bytes, UTF_8), e);
        }
    }

}
