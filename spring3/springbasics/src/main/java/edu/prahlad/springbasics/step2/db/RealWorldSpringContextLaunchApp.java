package edu.prahlad.springbasics.step2.db;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@ComponentScan
public class RealWorldSpringContextLaunchApp {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext((RealWorldSpringContextLaunchApp.class))){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
