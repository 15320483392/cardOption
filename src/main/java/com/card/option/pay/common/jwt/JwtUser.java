package com.card.option.pay.common.jwt;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * @author wangtao
 * @ClassName JwtUser
 * @date 2020/9/14 16:47
 */
@Data
@Accessors(chain = true)
public class JwtUser {

    private String userId;

    private String loginId;

    private String name;

    private String userName;

    private String phone;

    private String openId;

    private String roleId;

    private Date time;

    public JwtUser parseObject(String jsonStr){
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        return JSONObject.parseObject(jsonStr,this.getClass());
    }

    public Map<String,Object> toMap () {
        return JSONObject.parseObject(JSONObject.toJSONString(this),Map.class);
    }
}
