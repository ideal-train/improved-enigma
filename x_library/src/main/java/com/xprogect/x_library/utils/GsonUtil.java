package com.xprogect.x_library.utils;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/3/23.
 */

public class GsonUtil {

    /**
     * 将Json数据解析成相应的映射对象
     *
     * @param jsonData
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = null;
        try {
            result = gson.fromJson(jsonData, type);
        } catch (Exception e) {
            MyLog.e("GsonUtil", "parseJsonWithGson:" + "Gson解析失败");
        }
        return result;
    }




}
