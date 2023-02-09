package edu.prahlad.springbasics;

import edu.prahlad.springbasics.game.GameRunner;
import edu.prahlad.springbasics.game.Mario;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //1: Launch a Spring Context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        //2: Configure the things that we want Spring to manage
        //   - @Configuration Class
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("AgeOf"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address"));
    }
}
