package edu.prahlad.springbasics.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address){ }
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
        var person = new Person("ram", 25, new Address("Pankow", "Berlin"));
        return person;
    }

    @Bean("PersonInMethodCall")
    public Person personInMethodCall(){
        var person = new Person(name(), age(), address());
        return person;
    }

    @Bean//auto wiring is the magic - also the dependent beans are passed via priority: primary > beanName
    public Person personParameters(String name, int age, Address address3){
        var person = new Person(name, age, address3);
        return person;
    }

    @Bean
    public Address address(){
        var address = new Address("Baker Street", "London");
        return address;
    }

    @Bean
    public Address address2(){
        var address = new Address("Pankow", "Berlin");
        return address;
    }

    @Bean("address3")
    @Primary
    public Address address3(){
        var address = new Address("MG Road", "Banglore");
        return address;
    }
}
