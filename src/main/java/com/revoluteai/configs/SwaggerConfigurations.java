package com.revoluteai.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfigurations {



    @Bean
    public Docket swaggerConfig(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
//				.paths(PathSelectors.ant("/revoluteai/employee/*"))
                .apis(RequestHandlerSelectors.basePackage("com.revoluteai"))
                .build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo(){
        return new ApiInfo("Employee Project","Task by RevoluteAI","1","Sample API",new Contact("Lokesh",null,"lokeshkumartalari666@gmail.com"),"Not Required","", Collections.EMPTY_LIST);

    }
}
