package com.newer.homework0812.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newer.homework0812.domain.ResponseDate;
import com.newer.homework0812.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class MyInterceptor implements HandlerInterceptor {
    @Value("${auth:header}")
    private String header;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入了preHanldle方法");
        String token=request.getHeader(header);

        if(token!=null){
           String username = jwtTokenUtil.getUsernameByToken(token);
            if (username!=null){
                return true;
            }else {
                return false;
            }
        }else {

            responseMsg(response);
            return false;
        }

    }

    private void responseMsg(HttpServletResponse response){
        try{
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out=response.getWriter();
            ResponseDate responseDate=new ResponseDate("403","fobidden");
            ObjectMapper objectMapper=new ObjectMapper();
            String strData=objectMapper.writeValueAsString(responseDate);
            out.print(strData);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入了postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("进入了afterCompletion方法");
    }
}
