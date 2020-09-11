package com.easy.base.config.security;

import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {
//    private ObjectMapper objectMapper = new ObjectMapper();
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
//        Map<String, Object> map = new HashMap<>(16);
//        map.put("code", 0);
//        map.put("msg", "已经另一台机器登录，您被迫下线。" + sessionInformationExpiredEvent.getSessionInformation().getLastRequest());
//        String json = objectMapper.writeValueAsString(map);
//
//        sessionInformationExpiredEvent.getResponse().setContentType("application/json;charset=UTF-8");
//        sessionInformationExpiredEvent.getResponse().getWriter().write(json);

        // 如果是跳转html页面，url代表跳转的地址
        redirectStrategy.sendRedirect(sessionInformationExpiredEvent.getRequest(), sessionInformationExpiredEvent.getResponse(), "/Login");
    }
}
