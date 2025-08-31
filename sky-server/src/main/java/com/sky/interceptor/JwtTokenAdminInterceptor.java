package com.sky.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sky.constant.JwtClaimsConstant;
import com.sky.context.BaseContext;
import com.sky.properties.JwtProperties;
import com.sky.utils.JwtUtils;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor{

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 校验jwt
     * 
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断拦截的是controller方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            // 拦截的不是动态方法，放行
            return true;
        }
        log.info("jwt令牌校验中...");
        // // 1.从请求头获取令牌
        // String token = request.getHeader(jwtProperties.getAdminTokenName());

        // // 2.校验令牌
        // try {
        //     log.info("jwt校验：{}", token);
        //     Claims claims = JwtUtils.parseJWT(jwtProperties.getAdminSecretKey(), token);
        //     Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
        //     log.info("当前员工id：{}", empId);
        //     BaseContext.setCurrentId(empId);
        //     // 3.通过放行
        //     return true;
        // } catch (Exception ex) {
        //     // 4.不通过，响应401
        //     response.setStatus(401);
        //     return false;
        // }
        // 从Authorization请求头中获取令牌
        String token = null;
        String authHeader = request.getHeader(jwtProperties.getAdminTokenName());
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7); // 移除Bearer前缀
        }
        if (token == null) {
            response.setStatus(401);
            return false;
        }
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtils.parseJWT(jwtProperties.getAdminSecretKey(), token);
            log.info("jwt claims: {}", claims); // 新增
            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
            log.info("当前员工id:{}", empId);
            BaseContext.setCurrentId(empId);
            return true;
        } catch (Exception ex) {
            log.error("jwt解析异常", ex);
            response.setStatus(401);
            return false;
        }
    }
    
}
