package com.card.option.pay.domain.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.Assert;

/**
 * @author wangtao
 * @ClassName LoginInfo
 * @date 2020/9/14 17:14
 */
@Data
@Accessors(chain = true)
public class LoginInfo {

    private String userName;

    private String passWord;

    public void vsParam(){
        Assert.hasText(userName,"请输入账号");
        Assert.hasText(passWord,"请输入密码");
    }
}
