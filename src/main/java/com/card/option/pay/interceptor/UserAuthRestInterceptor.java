package com.card.option.pay.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.card.option.pay.common.context.BaseContextHandler;
import com.card.option.pay.common.context.LoginContext;
import com.card.option.pay.common.context.TokenContext;
import com.card.option.pay.common.http.RestResponse;
import com.card.option.pay.common.jwt.JwtUser;
import com.card.option.pay.common.utils.RedisTokenUtils;
import com.card.option.pay.common.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证登录用户
 * @author wangtao
 * @date 2019/12/23 19:49
 * @param  * @param null
 * @return
 */
@Slf4j
@Component
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTokenUtils redisTokenUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String token = request.getHeader(TokenContext.TOKENHEADER);
        if (StringUtils.isEmpty(token)) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(TokenContext.TOKENHEADER)) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        // 200 成功; 400 参数异; 401 认证签名过期; 402 登录已注销; 403 无权限; 404 未知地址; 405 请求方法错误; 406 该账号在其他地方登录; 500 后台异常 501 业务失败
        RestResponse restul = new RestResponse();
        try {
            token = token.replaceAll("bearer ","");
            JwtUser jwtUser = TokenUtils.validToken(token);
            if (null == jwtUser) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                restul.setStatus(HttpStatus.UNAUTHORIZED.value());
                restul.setMessage("身份认证已过期");
                response.getWriter().append(JSONObject.toJSONString(restul));
                return false;
            }
            // 判断是否被注销
            String loginId = redisTokenUtils.getPcLoginId(jwtUser.getUserId());
            if (loginId == null) {
                response.setStatus(HttpStatus.PAYMENT_REQUIRED.value());
                restul.setStatus(HttpStatus.PAYMENT_REQUIRED.value());
                restul.setMessage("登录已注销");
                response.getWriter().append(JSONObject.toJSONString(restul));
                return false;
            }
            // 是否已在其他地方登录
            if (!jwtUser.getLoginId().equals(loginId)) {
                response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
                restul.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
                restul.setMessage("该账号在其他地方登录");
                response.getWriter().append(JSONObject.toJSONString(restul));
                return false;
            }
            BaseContextHandler.setJWTUser(jwtUser);
            BaseContextHandler.set("token",token);
        }catch (NullPointerException ex){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            restul.setStatus(HttpStatus.UNAUTHORIZED.value());
            restul.setMessage("用户令牌为空");
            response.getWriter().append(JSONObject.toJSONString(restul));
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
