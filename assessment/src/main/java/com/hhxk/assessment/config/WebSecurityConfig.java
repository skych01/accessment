package com.hhxk.assessment.config;

import com.hhxk.assessment.security.CustomUserDetailsService;
import com.hhxk.assessment.security.LoginFailureHandler;
import com.hhxk.assessment.security.LoginSuccessHandler;
import com.hhxk.assessment.security.MyAuthenticationProvider;

import com.hhxk.assessment.util.JSONResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MyAuthenticationProvider authenticationProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //禁用csrf，（Cross-site request forgery）跨站请求伪造
        httpSecurity.csrf().disable();

        //AJAX请求，如果没登录则返回JSON格式的信息提示
/*      httpSecurity.exceptionHandling().authenticationEntryPoint((request, response, authException)->{
            String requestType = request.getHeader("x-requested-with");
            if (!StringUtils.isEmpty(requestType)) {
                JSONResult result = JSONResult.fail("invalid session");

                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().print(result.toString());
                response.getWriter().flush();
            } else {
                response.sendRedirect("/login");
            }
        });
         */

//        httpSecurity.authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/assets/**", "/css/**", "/js/**",
//                        "/img/**",  "/index", "/guide","/wx/**","/RMITest1","/acLogin","assessment/vendor/**","assessment/dist/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/manage/**","/wx/**","/checkAcLogin").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/assessment/pages/login")
//                .successForwardUrl("/index")
//                .successHandler(loginSuccessHandler)
//                .failureHandler(loginFailureHandler)
//                .permitAll()
//                .and()
//                .logout().
//                logoutUrl("/logout").
//                invalidateHttpSession(true)
//                .logoutSuccessUrl("/index")
//                .permitAll()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(1209600)
//                .tokenRepository(tokenRepository());
//

        httpSecurity.authorizeRequests()
                .antMatchers("*").permitAll();

    }
}
