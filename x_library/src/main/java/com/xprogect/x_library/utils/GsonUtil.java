package com.xprogect.x_library.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

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
//        Gson gson = new Gson();
        /*
         * 空字符串处理
         * 思路1.数据解析时处理
         * 思路2.数据调用时处理
         * 第二种需修改GsonFromat的get set方法 或者直接修改studio的get set模板 然后一个个处理(麻烦)，
         * 不能对json转bean生效，仅对studio手动生成的get set有效果
         * 所以这里采用的是第一种方式
         * */
        Gson gson = new GsonBuilder()
//               接管序列化和反序列化的过程 Gson解析null替换为空字符串
                .registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
                .create();
        T result = null;
        try {
            result = gson.fromJson(jsonData, type);
        } catch (Exception e) {
            MyLog.e("GsonUtil", "parseJsonWithGsonException:" + "--Gson解析失败--" + e.toString());
        }
        return result;
    }


    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @Override
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringNullAdapter();
        }
    }

    public static class StringNullAdapter extends TypeAdapter<String> {
        @Override
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
