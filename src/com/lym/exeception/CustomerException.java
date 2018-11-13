package com.lym.exeception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常实现类
 */
public class CustomerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mav = new ModelAndView();
        // 判断异常类型
        if (ex instanceof MessageException) {
            MessageException me = (MessageException) ex;
            mav.addObject("err", me.getMsg());
        } else {
            mav.addObject("err", "Unknow Exception...");
        }
        mav.setViewName("err");
        return mav;
    }
}
