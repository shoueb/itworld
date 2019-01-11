package com.shoueb.itworld.common.result;

import java.io.Serializable;

/**
 * @Description: 统一返回结果
 * @Author: yuangui.hu
 * @Date: 2019/01/11 13:26
 */
public class ResultRO<T>  implements Serializable{
    /**
     * 1代表成功
     */
    public static final  int SUCCESS=1;
    /**
     * 0代表失败
     */
    public static final  int ERROR=0;
    private int code;
    private String msg;
    private T data;
    public ResultRO(){

    }
    public ResultRO(int code,String msg,T data){
            this.code=code;
            this.msg=msg;
            this.data=data;
    }
    public static <T> ResultRO<T> success(){
        return new ResultRO(ResultRO.SUCCESS,"","");
    }
    public static <T> ResultRO<T> success(String msg){
        return new ResultRO(ResultRO.SUCCESS,msg,"");
    }
    public static <T> ResultRO<T> success(String msg,T data){
        return new ResultRO(ResultRO.SUCCESS,msg,data);
    }
    public static <T> ResultRO<T> success(T data){
        return new ResultRO(ResultRO.SUCCESS,"",data);
    }
    public static <T> ResultRO<T> error(){
        return new ResultRO(ResultRO.ERROR,"","");
    }
    public static <T> ResultRO<T> error(String msg){
        return new ResultRO(ResultRO.ERROR,msg,"");
    }
    public static <T> ResultRO<T> error(String msg,T data){
        return new ResultRO(ResultRO.ERROR,msg,data);
    }

    public  boolean isSuccess(){
        return this.getCode()==1;
    }
    public  boolean isError(){
        return this.getCode()!=1;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
