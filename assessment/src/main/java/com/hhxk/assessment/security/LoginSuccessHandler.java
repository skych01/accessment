package com.hhxk.assessment.security;

import com.hhxk.assessment.entity.base.DLog;
import com.hhxk.assessment.service.LogService;
import com.hhxk.assessment.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;


@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private LogService logService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();

        String ip = null;
        try {
            ip = Utils.getClientRealIP(request);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String extInfo =  String.format("username: %1$s", securityUser.getUsername());
        logService.writeLog(DLog.LogTypes.login, securityUser.getUserId(), ip, "账号登录成功", extInfo);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
