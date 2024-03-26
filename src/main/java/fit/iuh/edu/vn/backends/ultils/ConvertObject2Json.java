package fit.iuh.edu.vn.backends.ultils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertObject2Json {
//    private static final Gson gson = new GsonBuilder()
//            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
//            .create();
//    private static final Gson gson = new GsonBuilder()
//            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
//            .excludeFieldsWithoutExposeAnnotation()
//            .disableInnerClassSerialization()
//            .create();
    private static final Gson gson = new Gson();

    // Hàm để chuyển đổi object thành JSON
    public String objectToJson(Object obj) {
        return gson.toJson(obj);
    }

    // Hàm để chuyển đổi JSON thành object
    public <T> T jsonToObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    // Chuyển đổi List<Object> thành JSON
    public String listObjectToJson(List<Object> list) {
        return gson.toJson(list);
    }

    // Chuyển đổi JSON thành ArrayList<Object>
    public ArrayList<Object> jsonToArrayListObject(String json) {
        Type type = new TypeToken<ArrayList<Object>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
