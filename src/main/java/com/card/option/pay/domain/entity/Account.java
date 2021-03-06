package com.card.option.pay.domain.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author WTar
 * @date 2020/9/16 16:45
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Account对象", description="")
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户主键id")
    private String accountId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "账号")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;

    @ApiModelProperty(value = "角色权限id")
    private String roleId;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;


    @Override
    protected Serializable pkVal() {
        return this.accountId;
    }

}
