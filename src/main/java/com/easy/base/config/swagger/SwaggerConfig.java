package com.easy.base.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    Boolean swaggerEnabled=true;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.easy.base"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Base Project接口文档")
                .description("Base Project API")
                //.contact(new Contact("name", "个人主页url", "email")) //作者信息
                .version("0.0.1")
                .build();
    }
}
