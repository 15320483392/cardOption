package com.card.option.pay.common.utils;

import java.util.UUID;

/**
 * @author wangtao
 * @ClassName CommonUtils
 * @date 2020/9/14 17:58
 */
public class CommonUtils {

    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
