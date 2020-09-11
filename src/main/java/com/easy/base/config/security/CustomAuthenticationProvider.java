package com.easy.base.config.security;

import com.easy.base.service.impl.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private UserServiceImpl userService;

    public CustomAuthenticationProvider(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        CustomWebAuthenticationDetails customWebAuthenticationDetails = (CustomWebAuthenticationDetails) authentication.getDetails();

        String verifyCode = customWebAuthenticationDetails.getVerifyCode();
        if (!validateVerify(verifyCode)) {
            throw new DisabledException("验证码输入错误");
        }

        UserDetails userDetails = userService.loadUserByUsername(username);

        if (!userDetails.getPassword().equals(password)) {
            throw new BadCredentialsException("账号或密码错误");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean validateVerify(String verifyCode) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String validateCode = ((String) request.getSession().getAttribute("validateCode")).toLowerCase();
        logger.info("验证码: " + validateCode + ", 用户输入: " + verifyCode);
        if (validateCode == null) {
            return false;
        }
        verifyCode = verifyCode.toLowerCase();
        return validateCode.equals(verifyCode);
    }
}
