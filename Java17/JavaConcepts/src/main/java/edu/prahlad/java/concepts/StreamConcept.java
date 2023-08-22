package edu.prahlad.java.concepts;

import java.util.List;

public class StreamConcept {

    public record Person(String name, int age){}

    public record City(String name, List<Person> people){
        public City(String name, Person ...people){
            this(name, List.of(people));
        }
    }
}
