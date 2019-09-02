package com.example.demo.interceptor;

import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by onesafe on 02/09/2019 2:54 PM.
 */
@Slf4j
public class LoginValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler ...");
        log.info("preHandler ...");
        User  user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
        log.info("postHandle ...");
        // controller 方法调用完毕后，执行此方法
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion ...");
        log.info("afterCompletion ...");
        // 页面渲染完成后调用此方法, 一般用来清除某些资源等
    }
}
