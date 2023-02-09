package edu.prahlad.springbasics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age){ }
record Address(String firstLine, String city){}
@Configuration
public class HelloWorldConfig {

    @Bean
    public String name(){
        return "Rao";
    }

    @Bean("AgeOf")
    public int age(){
        return 28;
    }

    @Bean
    public Person person(){
        var person = new Person("ram", 25);
        return person;
    }

    @Bean
    public Address address(){
        var address = new Address("pankow", "berlin");
        return address;
    }
}
