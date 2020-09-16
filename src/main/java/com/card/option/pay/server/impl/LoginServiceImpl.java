package com.card.option.pay.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.card.option.pay.common.http.RestResponse;
import com.card.option.pay.common.jwt.JwtUser;
import com.card.option.pay.common.utils.CommonUtils;
import com.card.option.pay.common.utils.TokenUtils;
import com.card.option.pay.config.Applets;
import com.card.option.pay.domain.entity.Account;
import com.card.option.pay.domain.entity.User;
import com.card.option.pay.domain.entity.bo.LoginUserInfo;
import com.card.option.pay.domain.entity.vo.LoginInfo;
import com.card.option.pay.server.IAccountService;
import com.card.option.pay.server.ILoginInService;
import com.card.option.pay.server.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author wangtao
 * @ClassName LoginServiceImpl
 * @date 2020/9/14 17:16
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements ILoginInService {

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Applets applets;

    @Override
    public RestResponse<LoginUserInfo> loginIn(LoginInfo loginInfo) {
        RestResponse<LoginUserInfo> rest = new RestResponse<>();
        Account account = iAccountService.getOne(new QueryWrapper<Account>().eq("user_name",loginInfo.getUserName()));
        if (account == null) {
            return rest.Failure("账号不存在");
        }
        User user = iUserService.getById(account.getUserId());
        if (user == null) {
            return rest.Failure("用户不存在");
        }
        // 验证密码
        if (!passwordEncoder.matches(loginInfo.getPassWord(),account.getPassWord())) {
            // 登录失败
            return rest.Failure("登录失败,密码错误");
        }

        LoginUserInfo loginUserInfo = new LoginUserInfo();
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUserId(user.getUserId())
                .setLoginId(CommonUtils.UUID())
                .setName(user.getName())
                .setPhone(user.getPhone())
                .setRoleId(user.getRole())
                .setTime(new Date());
        loginUserInfo.setName(user.getName()).setToken(TokenUtils.createToken(jwtUser));

        return rest.Success("登录成功").setData(loginUserInfo);
    }

    @Override
    public RestResponse loginInWx() {
        log.info(JSONObject.toJSONString(applets));
        return new RestResponse().Success();
    }
}
