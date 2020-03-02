package com.example.swagerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启swagger
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("李白").apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.example.swagerdemo.controller")).build();
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("杜甫").apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.example.swagerdemo.controller")).build();
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("刘备").apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.example.swagerdemo.controller")).build();
    }
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles =Profiles.of("dev","test");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2).groupName("关羽").apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.example.swagerdemo.controller")).build();
    }
    private ApiInfo apiInfo(){
        Contact DEFAULT_CONTACT = new Contact("特爱冰红茶", "www.baidu.com", "2855212464@qq");
        return  new ApiInfo("Api swagger练习册",
                "前后端交互",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
