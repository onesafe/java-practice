package json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by onesafe on 28/09/2018.
 */
public class JSON {

    private static Gson parser = new Gson();

    public static <T> T fromJson(String str, Class<T> classOfT) {
        return parser.fromJson(str, classOfT);
    }

    public static String toJson(Object obj) {
        return parser.toJson(obj);
    }

    public static <T> T getData(byte[] bytes, Class<T> classOfT) {
        JsonObject jsonObject = parser.fromJson(new String(bytes), JsonObject.class);
        String data = jsonObject.get("data").toString();
        return parser.fromJson(data, classOfT);
    }
}
