package com.example.schoolmanagement_01.core.util;

import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public class TransformerUtils {

    public static final Map<String, String> dtoToPayload (Object object, String action){
        Map<String, String> result = ObjectMapperUtils.dtoToMap(object, new TypeReference<Map<String, String>>(){});
        result.put("action", action);
        Log.e("log", ObjectMapperUtils.dtoToString(result));
        return result;
    }
}
