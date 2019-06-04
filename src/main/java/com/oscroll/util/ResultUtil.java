package com.oscroll.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("api接口通用返回对象")
@Data
public class ResultUtil<T> {

    @ApiModelProperty(value = "返回码",dataType = "Integer")
    private Integer code;
    private String message;
    private T data;

    public ResultUtil(T data){
        this.code = 20000;
        this.message = "success";
        this.data = data;
    }

    public ResultUtil(String message){
        this.code = 40000;
        this.message = message;
    }

}
