package com.crosoften.utils.json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;


public final class JsonHandler {

    /**
     * @param message
     * @return
     */
    public static JsonObject buildReturnJson(String message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("responseMessage", message);

        return jsonObject;
    }


    /**
     * @param rawJson
     * @return
     */
    public static Map<String, String> jsonDeserialization(String rawJson) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();

        return gson.fromJson(rawJson, type);

    }
}
