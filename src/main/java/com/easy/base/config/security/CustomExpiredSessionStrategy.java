package com.easy.base.config.security;

import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException {
        // 如果是跳转html页面，url代表跳转的地址
        redirectStrategy.sendRedirect(sessionInformationExpiredEvent.getRequest(), sessionInformationExpiredEvent.getResponse(), "/Login");
    }
}
