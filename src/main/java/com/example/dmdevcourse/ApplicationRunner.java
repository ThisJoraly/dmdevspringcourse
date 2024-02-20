package com.example.dmdevcourse;

import com.example.dmdevcourse.config.DatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan

public class ApplicationRunner {
    public static void main(String[] args) {
         var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(context.getBeanDefinitionCount());
        System.out.println(context.getBean("pool1"));
        System.out.println(context.getBean(DatabaseProperties.class));
    }
}




//public static void main(String[] args) {
//        String value = "hello";
//        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
//        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
//        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));
//
//        try (var context = new AnnotationConfigApplicationContext()) {
//            context.register(ApplicationConfiguration.class);
//            context.getEnvironment().setActiveProfiles("web", "prod");
//            context.refresh();
//            // clazz -> String -> Map<String, Object>
//            var connectionPool = context.getBean("pool1", ConnectionPool.class);
//            System.out.println(connectionPool);
//
//            var companyService = context.getBean(CompanyService.class);
//            System.out.println(companyService.findById(1));
//        }
//
//    }
