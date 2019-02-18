package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HolidaySpringWsApplication extends SpringBootServletInitializer {

    /**
     * Para executar em containers da forma tradicional, ou seja,
     * como WAR. Sobrescrevendo método de @see {@link SpringBootServletInitializer}.
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(HolidaySpringWsApplication.class);
    }

    /**
     * Para rodar a aplicação via SpringBoot.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HolidaySpringWsApplication.class, args);
    }

}
