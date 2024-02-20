package com.example.dmdevcourse.config;

import com.example.dmdevcourse.database.pool.ConnectionPool;
import com.example.dmdevcourse.database.repository.CompanyRepository;
import com.example.dmdevcourse.database.repository.UserRepository;
import com.example.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;


//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = true)
@PropertySource(value = "classpath:application.yml")
@ComponentScan(basePackages = "com.example.dmdevcourse",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CompanyRepository.class),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
        })
public class ApplicationConfiguration {
    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool("test-name", 20);
    }
    @Bean
    @Scope
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 25);
    }

}
