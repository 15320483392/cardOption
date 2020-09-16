package com.card.option.pay.controller;


import com.card.option.pay.common.http.RestResponse;
import com.card.option.pay.domain.entity.User;
import com.card.option.pay.domain.entity.vo.UserExtVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangtao
 * @since 2020-09-14
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = {"用户信息接口"})
public class UserController {

    @ApiOperation(value = "查询用户信息")
    @GetMapping("/info")
    public RestResponse getUserInfo () {

        return new RestResponse().Success();
    }

    @ApiOperation(value = "保存用户信息")
    @PostMapping("/save")
    public RestResponse<User> saveUser(@RequestBody UserExtVO userExt){

        return null;
    }

    @ApiOperation(value = "查询用户扫码记录")
    @PostMapping("/scan/list")
    public RestResponse getScanCodeRecord(){

        return new RestResponse().Success();
    }
}
