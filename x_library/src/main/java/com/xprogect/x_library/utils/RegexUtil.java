package com.xprogect.x_library.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则
 */
public class RegexUtil {

    /**
     * is url
     *
     * @param url
     * @return
     */
    public static boolean isUrl(String url) {
        Pattern pattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
        return pattern.matcher(url).matches();
    }


    /**
     * 手机号正则
     */
    public static boolean isPhone(String mobiles) {
        //        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(170))\\d{8}$");
//        Pattern p = Pattern.compile("^\\d{11}$");
        Pattern p = Pattern.compile("^[1]\\d{10}$");
         /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
		 * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		 */
//        String telRegex = "[1][34578]\\d{9}";// "[1]"代表第1位为数字1，"[3458]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 验证码正则 默认6位
     */
    public static boolean isCodes(String codes) {
        Pattern p = Pattern.compile("\\d{6}$");
        Matcher m = p.matcher(codes);
        return m.matches();
    }

    /**
     * 验证码正则 验证码长度
     */
    public static boolean isCodes(String codes, int length) {
        Pattern p = Pattern.compile(String.format("\\d{%d}$", length));
        Matcher m = p.matcher(codes);
        return m.matches();
    }



    /***
     *
     * @param input : 银行卡号,例如"6225880137706868"
     * @return
     */
    public static String formBankCard(String input){
        String result=input.replaceAll("([\\d]{4})(?=\\d)", "$1 ");
        return result;
    }

}
