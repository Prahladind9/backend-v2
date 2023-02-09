package edu.prahlad.springbasics.practice.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //1: Launch a Spring Context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        //2: Configure the things that we want Spring to manage
        //   - @Configuration Class

        //3: Retrieve beans managed by Spring
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("AgeOf"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("PersonInMethodCall"));//case sensitive
        System.out.println(context.getBean("personParameters"));//case sensitive
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean(Address.class));
    }
}
