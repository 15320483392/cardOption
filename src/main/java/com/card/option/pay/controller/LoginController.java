package com.card.option.pay.controller;


import com.card.option.pay.common.http.RestResponse;
import com.card.option.pay.domain.entity.bo.LoginUserInfo;
import com.card.option.pay.domain.entity.vo.LoginInfo;
import com.card.option.pay.server.ILoginInService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  后台登录相关接口
 * </p>
 *
 * @author wangtao
 * @since 2020-09-14
 */
@Slf4j
@RestController
@RequestMapping("/sign")
@Api(value = "LoginController", tags = {"登录"})
public class LoginController {

    @Autowired
    private ILoginInService iLoginInService;

    @ApiOperation(value = "后台登录")
    @PostMapping("/in")
    public RestResponse<LoginUserInfo> loginIn(@RequestBody LoginInfo loginInfo){
        loginInfo.vsParam();
        return iLoginInService.loginIn(loginInfo);
    }

    @ApiOperation(value = "小程序微信登录")
    @PostMapping("/in/wx")
    public RestResponse loginInWx() {
        return iLoginInService.loginInWx();
    }

    @ApiOperation(value = "后台退出")
    @GetMapping("/out")
    public RestResponse loginOut(){

        return new RestResponse().Success();
    }

    @ApiOperation(value = "添加后台账号")
    @PostMapping("/register")
    public RestResponse addUser(){

        return null;
    }

}
