package com.card.option.pay.controller;


import com.card.option.pay.common.http.RestResponse;
import com.card.option.pay.entity.User;
import com.card.option.pay.entity.vo.UserExtVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangtao
 * @since 2020-09-14
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/save")
    public RestResponse<User> saveUser(@RequestBody UserExtVO userExt){

        return null;
    }

}
