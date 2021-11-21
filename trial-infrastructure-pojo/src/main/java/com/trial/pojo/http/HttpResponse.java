package com.trial.pojo.http;

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

}
