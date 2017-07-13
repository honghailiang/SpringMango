/**
 *
 */
package com.mango.jtt.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 *
 * @author HHL
 * @date 2016年11月23日
 */
@ControllerAdvice
public class APPWideExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler() {
        return "errorPage/404";
    }
}
