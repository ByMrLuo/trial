package com.trial.object.emnu;

/**
 * @方法说明: 返回枚举
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/21 23:29
 */
public enum HttpResponseEnum {

    SUCCESS(0, "success"),
    ERROR(0, "error");

    private Integer code;

    private String msg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    HttpResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
