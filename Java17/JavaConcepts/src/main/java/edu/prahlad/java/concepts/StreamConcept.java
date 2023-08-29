package edu.prahlad.java.concepts;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamConcept {

    public record Person(String name, int age){}

    public record City(String name, List<Person> people){
        public City(String name, Person ...people){
            this(name, List.of(people));
        }
    }

    static List<StreamConcept.Person> getPeopleFromCities(List<StreamConcept.City> cities) {
        return cities.stream()
                .flatMap(city -> city.people().stream())
                .collect(Collectors.toList());
    }

    static Optional<Integer> getPeopleAgeSum(
            List<StreamConcept.Person> people,
            Predicate<Integer> ageCondition,
            BinaryOperator<Integer> integerSumBinaryOperator) {
        return people.stream()
                .map(StreamConcept.Person::age)
                .filter(ageCondition)
                .reduce(integerSumBinaryOperator);
    }
}
