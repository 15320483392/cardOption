package com.card.option.pay.server;

import com.card.option.pay.common.http.RestResponse;
import com.card.option.pay.domain.entity.bo.LoginUserInfo;
import com.card.option.pay.domain.entity.vo.LoginInfo;

public interface ILoginInService {

    RestResponse<LoginUserInfo> loginIn(LoginInfo loginInfo);

    RestResponse loginInWx();
}
