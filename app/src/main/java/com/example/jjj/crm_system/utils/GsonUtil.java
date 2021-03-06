package com.example.jjj.crm_system.utils;

import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mr.Jadyn on 15/12/6.
 */
public class GsonUtil {
    private static final Gson gson = new Gson();

    public static <T> T parse(String str, Class<T> clazz) {
        if (str == null) return null;
        try {
            return gson.fromJson(str, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parse(JSONObject json, Class<T> clazz) {
        if (json == null) return null;
        try {
            return parse(json.toString(), clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseString(Object obj) {
        if (obj == null) return "";
        return gson.toJson(obj);
    }

    public static <T> List<T> stringToList(String str, Class<T[]> clazz) {
        if (TextUtils.isEmpty(str)) return new ArrayList<>();
        return Arrays.asList(parse(str, clazz));
    }

    public static <T> List<List<T>> stringToListList(String str, Class<T[][]> clazz) {
        if (TextUtils.isEmpty(str)) return new ArrayList<>();
        T[][] tmpList = parse(str, clazz);
        List<List<T>> resultList = new ArrayList<>();
        for (T[] it : tmpList) {
            resultList.add(Arrays.asList(it));
        }
        return resultList;
    }

}
