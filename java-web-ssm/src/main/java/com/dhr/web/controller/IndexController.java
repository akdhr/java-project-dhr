package com.dhr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/12/19.
 */
@Controller
public class IndexController {

    /**
     * 统一拦截处理
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {


        System.out.println("统一拦截处理...");

    }
}
