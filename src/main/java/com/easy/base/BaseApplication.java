package com.easy.base;

import com.easy.base.config.servlet.VerifyServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.easy.base.repository.mapper")
@EnableRedisHttpSession
@EnableTransactionManagement
@SpringBootApplication
public class BaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<VerifyServlet> servletRegistrationBean() {
		ServletRegistrationBean<VerifyServlet> registrationBean = new ServletRegistrationBean<>(new VerifyServlet());
		registrationBean.addUrlMappings("/GetVerifyCode");
		return registrationBean;
	}
}
