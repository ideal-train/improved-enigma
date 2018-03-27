package com.xprogect.enums;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2018/3/27
 * function：丧心病狂的节省内存的方法--优化枚举使用方法 （基于Intellij的“魔术常量”检查机制）
 */

public class OhterWay {

    public static final int VANILLA = 0;
    public static final int CHOCOLATE = 1;
    public static final int STRAWBERRY = 2;

    /**
     * 用 @IntDef "包住" 常量；
     *
     * @Retention 定义策略--注解仅存在与源码中,不加入到class文件中
     * 声明构造器
     */
    @IntDef({VANILLA, CHOCOLATE, STRAWBERRY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flavour {
    }


    public static String getFlavour(@Flavour int flavour) {
        int type = flavour;
        switch (type) {
            case CHOCOLATE:
                return "女";
            case STRAWBERRY:
                return "男";
            case VANILLA:
                return "位置";
            default:
                return "超限";
        }
    }
}
