package com.card.option.pay.server;

import com.card.option.pay.common.http.RestResponse;
import com.card.option.pay.entity.bo.LoginUserInfo;
import com.card.option.pay.entity.vo.LoginInfo;

public interface ILoginInService {

    RestResponse<LoginUserInfo> loginIn(LoginInfo loginInfo);
}
