package com.lll.security.controller.datasource;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * User: liujian
 * Date: 13-2-13
 * Time: 下午5:49
 */
public class MyWebBindingInitializer implements WebBindingInitializer {
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        //TODO 如何设置多个日期格式
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    //    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), false));
    }
}
