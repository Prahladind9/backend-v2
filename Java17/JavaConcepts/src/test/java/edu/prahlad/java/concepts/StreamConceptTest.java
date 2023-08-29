package edu.prahlad.java.concepts;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static edu.prahlad.java.concepts.StreamConcept.getPeopleAgeSum;
import static edu.prahlad.java.concepts.StreamConcept.getPeopleFromCities;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class StreamConceptTest {

    StreamConcept.City ny = new StreamConcept.City("Ny",
            new StreamConcept.Person("Paul", 25),
            new StreamConcept.Person("Sarah", 27),
            new StreamConcept.Person("Sandra", 47));
    StreamConcept.City la = new StreamConcept.City("La",
            new StreamConcept.Person("Ann", 85),
            new StreamConcept.Person("Charles", 97));

    StreamConcept.City dc = new StreamConcept.City("dc",
            new StreamConcept.Person("Boris", 45),
            new StreamConcept.Person("Emily", 67));


    @Test
    void checkOneToManyRelationshipBetweenCityAndPeople() {

        var cities = List.of(ny, la, dc);
        var people = getPeopleFromCities(cities);

        log.info("peopleList:{}", people);
        assertEquals(7, people.size());

        IntStream.range(0, 30)
                .skip(10).limit(10)
                .forEach(System.out::print);

        Optional<Integer> peopleAgeSum = getPeopleAgeSum(people, getAgeCondition(), getIntegerSumBinaryOperator()); //binaryOperation
        log.info("peopleAgeSum using binaryOperation:{}", peopleAgeSum);
    }


    @Test
    void checkOperationsOnStream() {
        var cities = List.of(ny, la, dc);
        var people = getPeopleFromCities(cities);

        //max (or min) age based on a given sort order
        var maxAge = people.stream().max(Comparator.comparingInt(StreamConcept.Person::age));
        log.info("maxAge:{}", maxAge);
        assertTrue(maxAge.isPresent());
        assertEquals(97, maxAge.get().age());

        //findFirst (or findAny()) get the element
        var findFirst = people.stream().filter(pupil -> pupil.name().contains("Sa")).findFirst();
        log.info("findFirst:{}", findFirst);
        assertTrue(findFirst.isPresent());
        assertEquals("Sarah", findFirst.get().name());

        var nameContainingCount = people.stream().filter(pupil -> pupil.name().contains("Sa")).count();
        assertEquals(2, nameContainingCount);

        var cityPeopleCount = cities.stream().collect(
                groupingBy(StreamConcept.City::name,
                        Collectors.summingInt(city -> city.people().size())
                ));
        log.info("cityPeopleCount:{}", cityPeopleCount);
    }

    private static Predicate<Integer> getAgeCondition() {
        return age -> age > 10;
    }

    private static BinaryOperator<Integer> getIntegerSumBinaryOperator() {
        return (i1, i2) -> i1 + i2;
    }


}
