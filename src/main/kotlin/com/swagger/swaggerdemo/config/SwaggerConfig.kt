package com.swagger.swaggerdemo.config

import com.sun.corba.se.pept.transport.ContactInfo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.function.Predicate

@Configuration
@EnableSwagger2

class SwaggerConfig:WebMvcConfigurer {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    fun appApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2).apiInfo(Info()).select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.swaggerdemo.controller"))
                .paths(path())
                .build()
    }
    fun Info():ApiInfo{
        return ApiInfoBuilder().title("SIMPLE API")
                .description("MY APPS API")
                .contact(contact())
                .version("2.0")
                .build()

    }
    fun contact():Contact{
        return Contact("jos","http://abc.com","j@gmail.com")
    }
    fun path(): com.google.common.base.Predicate<String>? {

        return  regex("/.*")
    }
}