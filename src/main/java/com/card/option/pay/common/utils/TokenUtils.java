package com.card.option.pay.common.utils;

import com.card.option.pay.common.context.TokenContext;
import com.card.option.pay.common.jwt.JwtUser;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * token生成、解析工具类
 */
@Slf4j
public class TokenUtils {

    //生成一个token
    private static String getToken(Map<String,Object> userObj) throws JOSEException {
        /**
         * JWSHeader参数：1.加密算法法则,2.类型
         * 一般只需要传入加密算法法则就可以。
         * 这里则采用HS256
         * JWSAlgorithm类里面有所有的加密算法法则，直接调用。
         */
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(userObj));
        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        //建立一个密匙
        //log.info("长度:"+secret.length);
        JWSSigner jwsSigner = new MACSigner(TokenContext.TOKENKEY.getBytes());
        //签名
        jwsObject.sign(jwsSigner);
        //生成token
        return jwsObject.serialize();
    }
    /**
     * 生成token的业务逻辑
     */
    public static String createToken(JwtUser jwtUser) {
        //获取生成token
        //建立载荷
        try {
            String token = TokenUtils.getToken(jwtUser.toMap());
            return token;
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  解析token
     */
    private static Map<String,Object> valid(String token) throws ParseException, JOSEException {

        JWSObject jwsObject = JWSObject.parse(token);
        //获取到载荷
        Payload payload=jwsObject.getPayload();
        //建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(TokenContext.TOKENKEY.getBytes());
        Map<String, Object> resultMap = new HashMap<>();
        //判断token
        if (jwsObject.verify(jwsVerifier)) {
            resultMap.put("result", 0);
            //载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("data", jsonObject);
        }else {
            resultMap.put("result", 1);
        }
        return resultMap;
    }

    /**
     * 处理解析的业务逻辑
     */
    public static JwtUser validToken(String token) throws ParseException, JOSEException {
        JWSObject jwsObject = JWSObject.parse(token);
        //获取到载荷
        Payload payload=jwsObject.getPayload();
        //建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(TokenContext.TOKENKEY.getBytes());
        Map<String, Object> resultMap = new HashMap<>();
        //判断token
        if (jwsObject.verify(jwsVerifier)) {
            //载荷的数据解析成json对象。
            return new JwtUser().parseObject(payload.toJSONObject().toJSONString());
        }else {
            return null;
        }
    }

    /**
     * 传入请求头，拿到当前登录用户信息
     * @param request
     * @return
     */
    public static JwtUser getJwtUser(HttpServletRequest request) throws ParseException, JOSEException {
        String token = request.getHeader("Authorization");
        //方便测试
        if(StringUtils.isEmpty(token)){
            return null;
        }
        JwtUser data = validToken(token);
        return data;
    }
}