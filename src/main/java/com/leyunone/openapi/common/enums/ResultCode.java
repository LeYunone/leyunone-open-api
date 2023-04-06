package com.leyunone.openapi.common.enums;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
public enum ResultCode {

    /**
     * 通用错误
     */
    TOKEN_NOT_EXIST(100001, "token不存在"),
    SITE_NOT_EXIST(100002, "site不存在"),
    TOKEN_SITE_NOT_EXIST(100003, "token 或 site不存在"),
    PARAM_NOT_EXIST(100004,"参数不存在"),


    /**
     * 服务器错误
     */
    SUCCESS(200, "操作成功"),
    ERROR(404, "操作失败"),
    RPC_UNKNOWN_ERROR(1000017, "远程服务调用未知错误"),
    RPC_TIMEOUT(1000016, "远程服务调用超时"),
    RPC_ERROR_503(1000015, "远程服务不可用");

    ;

    private Integer status;

    private String desc;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResultCode(Integer status, String desc) {
        this.desc = desc;
        this.status = status;
    }

}
