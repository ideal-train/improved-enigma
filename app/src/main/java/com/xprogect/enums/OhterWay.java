package com.xprogect.enums;

import android.support.annotation.IntDef;

import com.xprogect.MyApplication;
import com.xprogect.application.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2018/3/27
 * function：丧心病狂的节省内存的方法--优化枚举使用方法 （基于Intellij的“魔术常量”检查机制）
 */

public class OhterWay {

    public static final int HOME_0 = 0;
    public static final int FIND_1 = 1;
    public static final int CHAT_2 = 2;
    public static final int MINE_3 = 3;

    /**
     * 用 @IntDef "包住" 常量；
     *
     * @Retention 定义策略--注解仅存在与源码中,不加入到class文件中
     * 声明构造器
     */
    @IntDef({HOME_0, FIND_1, CHAT_2, MINE_3})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flavour {
    }


    public static String getFlavour( @Flavour int flavour) {
        int type = flavour;
        switch (type) {
            case HOME_0:
                return MyApplication.getContext().getString(R.string.home);
            case FIND_1:
                return MyApplication.getContext().getString(R.string.find);
            case CHAT_2:
                return MyApplication.getContext().getString(R.string.chat);
            case MINE_3:
                return MyApplication.getContext().getString(R.string.mine);
            default:
                return MyApplication.getContext().getString(R.string.other);
        }
    }
}
