package com.newbegin.project.newbegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author L034E
 * @version 1.0
 * @since 1.0
 * this way it will automatically detect all your annotated components,
 * configuration classes, etc. defined in this package and all subpackages.1
 * аннотация @SpringBootApplication заменяет в себе вот эти три:
 * Configuration
 *  EnableAutoConfiguration
 *  ComponentScan  to automatically detect your class and have an instance created.
 * The @SpringBootApplication annotation is a so-called composed annotation and
 * consists of the earlier needed annotations.
 * Target({ElementType.TYPE})
 * Retention(RetentionPolicy.RUNTIME)
 *  Documented
 *  Inherited
 * SpringBootConfiguration
 * The @SpringBootConfiguration is a specialized @Configuration annotation.
 * It indicates that this is a Spring Boot-based application.
 *  EnableAutoConfiguration
 * ComponentScan
 *
 */
@EnableAsync
@SpringBootApplication
public class NewbeginApplication {

    /**
     * Here start point of the program
     * @param args command line values
     * Let’s create a NewbeginApplication class with a main method. The main method calls
     * SpringApplication.run with the NewbeginApplication.class and arguments from the
     * main method. The run method returns an ApplicationContext, which is used to
     * retrieve the bean names from ApplicationContext. The names are sorted and then
     * printed to the console
     * spoiler: there are no names displayed here, but there are many.
     */
    public static void main(String[] args) {
        SpringApplication.run(NewbeginApplication.class, args);
    }

}
