package com.card.option.pay.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 请求结果返回类
 * @author wangtao
 * @date 2019/10/2 12:30
 * @return
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="RestResponse",description="接口返回对象")
public class RestResponse<T> {

    @ApiModelProperty(name="data",value="返回数据")
    private T data;

    @ApiModelProperty(name="message",value="描述")
    private  String message;

    @ApiModelProperty(name="status",value="请求状态码")
    private Integer status;

    public RestResponse() {
        this.status = 200;
    }

    public RestResponse<T> Success(){
        this.message = "SUCCESS";
        return this;
    }

    public RestResponse<T> Success(String msg){
        this.message = msg;
        return this;
    }

    public RestResponse<T> Success(String msg,T data){
        this.message = msg;
        this.data = data;
        return this;
    }

    public RestResponse<T> Failure(String msg){
        this.status = 500;
        this.message = msg;
        return this;
    }

    public RestResponse<T> Failure(String msg,T data){
        this.status = 500;
        this.message = msg;
        this.data = data;
        return this;
    }


    public RestResponse<T> Failure(Integer status,String msg){
        this.status = status;
        this.message = msg;
        return this;
    }

    public RestResponse<T> Failure(Integer status,String msg,T data){
        this.status = status;
        this.message = msg;
        this.data = data;
        return this;
    }
}
