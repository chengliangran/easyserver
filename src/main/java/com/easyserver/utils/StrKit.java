package com.easyserver.utils;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class StrKit {
    public static boolean isBlank(String... strs){
        for (String str : strs) {
            if (str==null||"".equals(str)){
                return true;
            }
        }
        return false;
    }

    public static boolean isNotBlank(String... strs){
        if (isBlank(strs)){
            return false;
        }else {
            return true;
        }
    }
}
