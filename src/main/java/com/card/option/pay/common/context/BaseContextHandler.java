package com.card.option.pay.common.context;

import com.card.option.pay.common.jwt.JwtUser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2019/12/26 17:21
 */
public class BaseContextHandler {

    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static JwtUser getJWTInfo(){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
            return new JwtUser();
        }
        return (JwtUser) map.get("jwt");
    }

    public static void setJWTUser(JwtUser jwtUser){
        if (jwtUser == null) {
            return;
        }
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put("jwt",jwtUser);
    }

    public static void remove(){
        threadLocal.remove();
    }
}

