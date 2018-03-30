package com.xprogect.x_library.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * SharePreference工具类，用于进行数据缓存以及获取
 */
public class SPUtil {
    private static Map<String, SPUtil> sSPMap = new HashMap<>();
    private SharedPreferences sp;

    /**
     * 获取SP实例 默认的SharedPreferences
     *
     * @return {@link SPUtil}
     */
    public static SPUtil getInstance(@NonNull Context context) {
        return getInstance(context, "");
    }

    /**
     * 获取SP实例 new SharedPreferences
     *
     * @param spName SharedPreferences名字
     * @return {@link SPUtil}
     */
    public static SPUtil getInstance(@NonNull Context context, @NonNull String spName) {
        if (isSpace(spName)) spName = "Default_SPUtils";
        SPUtil sp = sSPMap.get(spName);
        if (sp == null) {
            sp = new SPUtil(context, spName);
            sSPMap.put(spName, sp);
        }
        return sp;
    }

    private static boolean isSpace(String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private SPUtil(@NonNull Context context, @NonNull String spName) {
        sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    /**
     * 缓存对象 注意序列化 implements Serializable
     *
     * @param key 缓存键
     * @param t   缓存数值
     * @param <T> 数据类型
     * @return boolean 缓存状态，默认一般都是会成功的
     */
    public <T> boolean saveObjectToShare(@NonNull String key, @NonNull T t) {
        try {
            Editor editor = sp.edit();
            if (t == null) {
                editor.putString(key, "");
                editor.commit();
                return true;
            }
            ByteArrayOutputStream toByte = new ByteArrayOutputStream();
            ObjectOutputStream oos;

            oos = new ObjectOutputStream(toByte);
            oos.writeObject(t);
            String payCityMapBase64 = new String(Base64.encode(toByte.toByteArray(), Base64.DEFAULT));

            editor.putString(key, payCityMapBase64);
            editor.commit();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 从缓存中获得存储的对象
     *
     * @param key 键
     * @param <T> 数据类型
     * @return T 返回的数据
     */
    public <T> T getObjectFromShare(@NonNull String key) {
        try {
            String payCityMapBase64 = sp.getString(key, "");
            if (payCityMapBase64.length() == 0) {
                return null;
            }
            byte[] base64Bytes = Base64.decode(payCityMapBase64, Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 缓存字符串
     *
     * @param key   键
     * @param value 字符串数据
     */
    public void put(@NonNull String key, @NonNull String value) {
        Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 得到缓存的字符串
     *
     * @param key 键
     * @return String 字符串数据
     */
    public String getString(@NonNull String key) {
        return sp.getString(key, "");
    }

    /**
     * 得到缓存的字符串
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public String getString(@NonNull String key, @NonNull String defaultValue) {
        return sp.getString(key, defaultValue);
    }


    /**
     * SP中写入String集合
     *
     * @param key    键
     * @param values 值
     */
    public void put(@NonNull String key, @NonNull Set<String> values) {
        sp.edit().putStringSet(key, values).apply();
    }

    /**
     * SP中读取StringSet
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值{@code Collections.<String>emptySet()}
     */
    public Set<String> getStringSet(@NonNull String key) {
        return getStringSet(key, Collections.<String>emptySet());
    }

    /**
     * SP中读取StringSet
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public Set<String> getStringSet(@NonNull String key, @NonNull Set<String> defaultValue) {
        return sp.getStringSet(key, defaultValue);
    }

    /**
     * 保存int类型数据
     *
     * @param key   键
     * @param value 缓存的整形数据
     */
    public void put(@NonNull String key, @NonNull int value) {
        Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * 得到int类型数据
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public int getInt(@NonNull String key) {
        return sp.getInt(key, -1);
    }

    /**
     * SP中读取int
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public int getInt(@NonNull String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    /**
     * 缓存boolen类型数据
     *
     * @param key   key
     * @param value boolen 类型数据
     */
    public void put(@NonNull String key,  boolean value) {
        Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 得到boolen类型数据
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值{@code false}
     */
    public boolean getBoolean(@NonNull String key) {
        return sp.getBoolean(key, false);
    }


    /**
     * 保存float类型数据
     *
     * @param key   键
     * @param value 缓存的数据
     */
    public void put(@NonNull String key, float value) {
        Editor editor = sp.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * 得到float类型数据
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public float getFloat(@NonNull String key) {
        return sp.getFloat(key, -1F);
    }

    /**
     * SP中读取float
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public float getFloat(@NonNull String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    /**
     * 保存long类型数据
     *
     * @param key   键
     * @param value 数据
     */
    public void put(@NonNull String key,  long value) {
        Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * 得到long类型数据
     *
     * @param key 键
     *            * @return 存在返回对应值，不存在返回默认值-1
     */
    public long getLong(@NonNull String key) {
        return sp.getLong(key, -1L);
    }

    /**
     * SP中读取long
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public long getLong(@NonNull String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }




    /**
     * SP中获取所有键值对
     *
     * @return Map对象
     */
    public Map<String, ?> getAll() {
        return sp.getAll();
    }

    /**
     * SP中是否存在该key
     *
     * @param key 键
     * @return {@code true}: 存在<br>{@code false}: 不存在
     */
    public boolean contains(@NonNull String key) {
        return sp.contains(key);
    }

    /**
     * SP中移除该key
     *
     * @param key 键
     */
    public void remove(@NonNull String key) {
        sp.edit().remove(key).apply();
    }

    /**
     * SP中清除所有数据
     */
    public void clear() {
        sp.edit().clear().apply();
    }
}
