package com.crosoften;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * É chamado ao iniciar a aplicação. Retorna todos os beans que foram criados pela aplicação
     * ou foram adicionados automaticamente graças ao Spring Boot. Ele os classifica e os imprime.
     *
     * @param applicationContext Contexto da Aplicação
     * @return Um array contando todos os Beans utilizados pala aplicação
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beansNames = applicationContext.getBeanDefinitionNames();

            Arrays.sort(beansNames);

            for (String beanName : beansNames) {
                System.out.println(beanName);
            }
        };
    }

}
