package com.leyunone.openapi.common.response;

import com.leyunone.openapi.common.enums.ResultCode;
import lombok.*;

import java.io.Serializable;

/**
 * @author leyunone
 * @create 2021-08-10 15:05
 *   一般响应结果集
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class DataResponse<T> implements Serializable {

    private T data;

    private boolean status;

    private Object message;

    private Integer code;

    public DataResponse() {
    }

    public static <T> DataResponse<T> of(T data) {
        DataResponse<T> response = new DataResponse();
        response.setStatus(true);
        response.setData(data);
        response.setCode(ResultCode.SUCCESS.getStatus());
        response.setMessage(ResultCode.SUCCESS.getDesc());
        return response;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> DataResponse<T> of(boolean status, ResultCode ResultCode, T data) {
        DataResponse<T> response = new DataResponse();
        response.setStatus(status);
        response.setData(data);
        response.setCode(ResultCode.getStatus());
        response.setMessage(ResultCode.getDesc());
        return response;
    }

    public static DataResponse buildFailure(ResultCode ResultCode) {
        return of(false, ResultCode, (Object)null);
    }

    public static DataResponse buildFailure(String message) {
        DataResponse response = of(false, ResultCode.ERROR, (Object)null);
        response.setMessage(message);
        return response;
    }

    public static DataResponse buildFailure(Object message) {
        DataResponse response = of(false, ResultCode.ERROR, (Object)null);
        response.setMessage(message);
        return response;
    }

    public static DataResponse buildFailure(){
        DataResponse response = new DataResponse();
        response.setStatus(false);
        response.setCode(ResultCode.ERROR.getStatus());
        response.setMessage(ResultCode.ERROR.getDesc());
        return response;
    }

    public static DataResponse buildSuccess() {
        DataResponse response = new DataResponse();
        response.setStatus(true);
        response.setCode(ResultCode.SUCCESS.getStatus());
        response.setMessage(ResultCode.SUCCESS.getDesc());
        return response;
    }


}
