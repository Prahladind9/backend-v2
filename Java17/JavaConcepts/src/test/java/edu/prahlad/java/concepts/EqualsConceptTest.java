package edu.prahlad.java.concepts;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EqualsConceptTest {

    @Test
    void given_twoSameMoneyObjects_then_equalsFails(){
        EqualsConcept.MoneyWithoutEquals income = new EqualsConcept.MoneyWithoutEquals(55, "USD");
        EqualsConcept.MoneyWithoutEquals expenses = new EqualsConcept.MoneyWithoutEquals(55, "USD");
        log.info("income:{}", income);
        log.info("expenses:{}", expenses);
        assertNotEquals(income, expenses);
        assertFalse(income.equals(expenses));
    }


    @Test
    void given_twoSameMoneyObjects_and_equalsOverride_then_equalsSucceeds(){
        EqualsConcept.MoneyWithEquals income = new EqualsConcept.MoneyWithEquals(55, "USD");
        EqualsConcept.MoneyWithEquals expenses = new EqualsConcept.MoneyWithEquals(55, "USD");
        log.info("income:{}", income);
        log.info("expenses:{}", expenses);
        assertEquals(income, expenses);
        assertTrue(income.equals(expenses));
    }

}
