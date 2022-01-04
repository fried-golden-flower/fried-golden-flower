package com.example.friedgoldenflower.common.interceptor;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //拦截逻辑
        User user = (User) request.getSession().getAttribute("loginUser");
        if (Objects.isNull(user)) {
            LOGGER.info("没有权限请先登陆");
            //未登陆，返回登陆界面
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("没有权限请先登陆");
            request.setAttribute("result", result);
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        } else {
            //已登陆，放行请求
//            if (Objects.isNull(user.getCurHourse())){
//                request.getRequestDispatcher("hourse/hourse").forward(request, response);
                return true;
//            }
        }
    }
}
