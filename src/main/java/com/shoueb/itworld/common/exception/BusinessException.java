package com.shoueb.itworld.common.exception;

/**
 * @Description: 业务操作异常
 * @Author: yuangui.hu
 * @Date: 2019/01/11 13:26
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 4476127218360943282L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
