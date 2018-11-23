package com.hhxk.assessment.security;



import com.hhxk.assessment.service.LogService;
import com.hhxk.assessment.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private LogService logService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //TODO 错误次数限制、锁定用户、解锁用户

        String username = httpServletRequest.getParameter("username");

        StringBuilder sb = new StringBuilder();
        sb.append("username: ").append(username).append(",error: ");
        sb.append(e.getMessage());

        String ip = Utils.getClientRealIP(httpServletRequest);
        //logService.writeLog(DLog.LogTypes.login,e, ip, "账号登录失败", sb.toString());

        httpServletResponse.sendRedirect("login?error");
    }
}
