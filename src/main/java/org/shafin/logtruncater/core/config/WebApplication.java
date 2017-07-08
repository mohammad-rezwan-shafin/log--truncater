package org.shafin.logtruncater.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan(
        basePackages = {
            "org.shafin.logtruncater.core.service",            
            "org.shafin.logtruncater.controller",
        }
)
public class WebApplication extends SpringBootServletInitializer {
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(WebApplication.class);
    }

    
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

//    @Bean
//    public RestTemplate getRestTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        List<HttpMessageConverter<?>> listConverters = new ArrayList<>();
//        listConverters.add(new MappingJackson2HttpMessageConverter());
//        listConverters.add(new MappingJackson2XmlHttpMessageConverter());
//
//        restTemplate.setMessageConverters(listConverters);
//        restTemplate.setRequestFactory(
//            new BufferingClientHttpRequestFactory(
//                new SimpleClientHttpRequestFactory()
//            )
//        );
//
//        return restTemplate;
//    }    
}
