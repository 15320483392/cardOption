package com.card.option.pay.controller;


import com.card.option.pay.common.http.RestResponse;
import com.card.option.pay.common.jwt.JwtUser;
import com.card.option.pay.entity.bo.LoginUserInfo;
import com.card.option.pay.entity.vo.LoginInfo;
import com.card.option.pay.server.ILoginInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  登录相关接口
 * </p>
 *
 * @author wangtao
 * @since 2020-09-14
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginInService iLoginInService;

    @PostMapping("/in")
    public RestResponse<LoginUserInfo> loginIn(@RequestBody LoginInfo loginInfo){
        loginInfo.vsParam();
        return iLoginInService.loginIn(loginInfo);
    }

    @PostMapping("/register")
    public RestResponse addUser(){

        return null;
    }

}
