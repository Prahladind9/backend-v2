package edu.prahlad.java.concepts;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class EnumConceptTest {
    @Test
    void given_enum_then_hasdefaultPriority(){
        EnumConcept.CrewMember ram = new EnumConcept.CrewMember(EnumConcept.FlightCrew.PILOT, "ram");
        EnumConcept.CrewMember jack = new EnumConcept.CrewMember(EnumConcept.FlightCrew.FLIGHT_ATTENDANT, "jack");

        log.info("checking who's in-charge based on default priority");
        var boss = ram.getJob().compareTo(jack.getJob()) > 0 ? ram: jack;
        log.info("Boss:{}", boss);
        assertEquals(boss, ram);
        assertEquals(boss.getJob().getTitle(), EnumConcept.FlightCrew.PILOT.getTitle());
    }
}
