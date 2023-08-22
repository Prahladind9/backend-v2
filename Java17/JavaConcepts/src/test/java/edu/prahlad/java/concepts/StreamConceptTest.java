package edu.prahlad.java.concepts;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class StreamConceptTest {

    @Test
    void checkOneToManyRelationshipBetweenCityAndPeople() {
        var ny = new StreamConcept.City("Ny",
                new StreamConcept.Person("Paul", 25),
                new StreamConcept.Person("Sarah", 27));
        var la = new StreamConcept.City("La",
                new StreamConcept.Person("Ann", 85),
                new StreamConcept.Person("Charles", 97));

        var dc = new StreamConcept.City("dc",
                new StreamConcept.Person("Boris", 45),
                new StreamConcept.Person("Emily", 67));


        var cities = List.of(ny, la, dc);
        var people = cities.stream()
                .flatMap(city -> city.people().stream())
                .collect(Collectors.toList());

        log.info("peopleList:{}", people);
        assertEquals(6, people.size());


        IntStream.range(0, 30)
                .skip(10).limit(10)
                .forEach(System.out::print);


        Optional<Integer> peopleAgeSum = people.stream()
                .map(StreamConcept.Person::age)
                .filter(age -> age > 10)
                .reduce((i1, i2) -> i1 + i2); //binaryOperation
        log.info("peopleAgeSum using binaryOperation:{}", peopleAgeSum);
    }
}
