package ru.sergey_gusarov.hw4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.sergey_gusarov.hw4.service.StartTest;


@SpringBootApplication
public class MainUserTesting {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainUserTesting.class, args);
        context.getBean(StartTest.class).run();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasenames("/i18/exception-messages", "/i18/shell-message");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
