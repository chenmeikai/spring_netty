/**
 * Copyright © 2018
 *
 * @Package: BaseController.java
 * @author: Administrator
 * @date: 2018年5月6日 上午11:40:19
 */
package com.kenhome.server.controller;


import com.kenhome.common.constant.universal.ResponseEnum;
import com.kenhome.common.model.universal.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.Set;


/**
 * @Description:统一异常处理
 * @author: cmk
 * @date: 2018年5月6日 上午11:40:19
 */
@ControllerAdvice
@Slf4j
public class ExceptionController {

    
    /**
     *
     * @Description: spring validation 实体类绑定校验响应
     * @auther: cmk
     * @date: 17:27
     * @param: [fooBindingResult]
     * @return: com.kenhome.common.model.universal.ResponseModel
     *
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseModel bindException(BindingResult fooBindingResult) {

        if (fooBindingResult.hasErrors()) {

            String name =fooBindingResult.getFieldErrors().get(0).getField();
            String message=fooBindingResult.getFieldErrors().get(0).getDefaultMessage();
            String result =String.format("校验失败的参数：%s,失败原因:%s", name,message);

            return ResponseModel.fail(result);
        }
        return ResponseModel.fail(ResponseEnum.ERROR);
    }

    /**
     * @Description: spring validation 方法注解参数校验响应
     * @auther: cmk
     * @date: 17:27
     * @param: [fooBindingResult]
     * @return: com.kenhome.common.model.universal.ResponseModel
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResponseModel bindException(ConstraintViolationException cve) {

        Set<ConstraintViolation<?>> cves = cve.getConstraintViolations();

        String result="";
        for (ConstraintViolation<?> constraintViolation : cves) {
            Path propertyPath = constraintViolation.getPropertyPath();
            String name = propertyPath.toString().split("\\.")[1];
            result = String.format("校验失败的参数：%s,失败原因:%s",name,constraintViolation.getMessage());
            break;
        }
        return ResponseModel.fail(result);
    }


    /**
     * @Description:  统一异常处理响应
     * @auther: cmk
     * @date: 17:26
     * @param: [request, response, e]
     * @return: com.kenhome.common.model.universal.ResponseModel
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseModel handleBaseException(HttpServletRequest request, HttpServletResponse response, Exception e) {

        log.error(request.getRequestURL() + " →有捕捉到的异常如下↓", e);

        return ResponseModel.fail(ResponseEnum.ERROR);
    }

}


