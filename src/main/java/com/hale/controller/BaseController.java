package com.hale.controller;

import com.hale.error.BusinessException;
import com.hale.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        Map<String, Object> map = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException exception = (BusinessException) ex;
            CommonReturnType type = new CommonReturnType();
            type.setStatus("fail");

            map.put("errCode", exception.getErrCode());
            map.put("errMsg", exception.getErrMsg());
            type.setData(map);
        }else {
            map.put("errCode", 00002);
            map.put("errMsg","未知错误");
        }
        return CommonReturnType.create(map,"fail");
    }
}
