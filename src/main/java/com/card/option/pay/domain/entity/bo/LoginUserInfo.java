package com.card.option.pay.domain.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wangtao
 * @ClassName LoginUserInfo
 * @date 2020/9/14 17:45
 */
@Data
@Accessors(chain = true)
public class LoginUserInfo {

    private String name;

    private String token;
}
