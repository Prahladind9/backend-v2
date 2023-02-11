package edu.prahlad.springbasics.step1.game2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);
        context.getBean(GameConsole.class).up();
        context.getBean(GameRunner.class).run();
        context.getBean("gameRunner2");
    }
}
