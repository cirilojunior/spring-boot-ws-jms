package br.com.minhaempresa.application.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.minhaempresa") // Necessario porque esta classe não está no pacote raíz da aplicação.
public class Application extends SpringBootServletInitializer {

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
        return builder.sources(Application.class);
    }

    /**
     * Para rodar a aplicação via SpringBoot.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
