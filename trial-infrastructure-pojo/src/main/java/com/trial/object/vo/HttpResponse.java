package com.trial.object.vo;

import com.trial.object.emnu.HttpResponseEnum;
import lombok.Data;

/**
 * @方法说明:返回统一返回类
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/21 23:13
 */
@Data
public class HttpResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    public void success(T data){
        this.code = HttpResponseEnum.SUCCESS.getCode();
        this.msg = HttpResponseEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public void fail(HttpResponseEnum fail){
        this.code = fail.getCode();
        this.msg = fail.getMsg();
    }

}
