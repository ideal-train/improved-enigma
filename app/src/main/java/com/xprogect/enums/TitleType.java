package com.xprogect.enums;

/**
 * 导航栏Enum
 * 安卓开发应避免使用Enum（枚举类），因为相比于静态常量Enum会花费两倍以上的内存。使用@IntDef注解来代替枚举是个不错的选择。
 */
public enum TitleType {

    /**
     * 焦点
     */
    getinfo((byte) 1, "焦点", "info"),
    /**
     * 百科改为史记
     */
    getbaike((byte) 2, "史记", "baike"),
    /**
     * 悬赏
     */
    gethiree((byte) 3, "悬赏", "hire"),
    /**
     * 圈子
     */
    getqun((byte) 4, "圈子", "qun"),
    /**
     * 排行：match
     */
    paihang((byte) 5, "排行", "match"),

    /**
     * 影视：filmbooks
     */
    filmbooks((byte) 6, "影视", "filmbooks"),

    /**
     * 私密：privacy
     */
    privacy((byte) 7, "私密", "privacy"),;


    public byte code;
    public String title;
    public String text;

    public String getKey() {
        return text;
    }

    TitleType(String code) {
        this.text = text;
    }


    TitleType(byte code, String title, String text) {
        this.code = code;
        this.title = title;
        this.text = text;
    }

    /**
     * @param code 下标
     * @return 返回网络请求需要的参数
     */
    public static String getKey(byte code) {
        TitleType em = getByCode(code);
        if (em != null)
            return em.text;
        return "info";
    }

    /**
     * @param code 下标
     * @return 返回布局上要显示的内容
     */
    public static String getTitle(byte code) {
        TitleType em = getByCode(code);
        if (em != null)
            return em.title;
        return "其他";
    }

    /**
     * @param text 网络请求需要的参数
     * @return 返回下标
     */
    public static int getCode(String text) {
        TitleType em = getByCode(text);
        if (em != null)
            return em.code;
        return 0;
    }

    /**
     * @param code 下标
     * @return 该条枚举
     */
    private static TitleType getByCode(String code) {
        for (TitleType type : TitleType.values()) {
            if (code == type.text)
                return type;
        }
        return null;
    }

    /**
     * @param code 下标
     * @return 该条枚举
     */
    private static TitleType getByCode(int code) {
        for (TitleType type : TitleType.values()) {
            if (code == type.code)
                return type;
        }
        return null;
    }
}
