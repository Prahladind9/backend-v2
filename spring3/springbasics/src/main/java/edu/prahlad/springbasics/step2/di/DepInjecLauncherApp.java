package edu.prahlad.springbasics.step2.di;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass{
    Dependency1 dependency1;
    Dependency2 dependency2;

    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public void print(){
        System.out.println("dependency1: "+ dependency1 + "dependency2: "+ dependency2);
    }
}

@Component
class Dependency1{

}

@Component
class Dependency2{

}


@Configuration
@ComponentScan
public class DepInjecLauncherApp {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(DepInjecLauncherApp.class)){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
            context.getBean(YourBusinessClass.class).print();
        }
    }
}
