package edu.prahlad.springbasics.step2.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class BusinessCalculationService {
    public DataService dataService;

    @Autowired
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
        System.out.println("resolved db: "+dataService);
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
