package edu.prahlad.springbasics.step2.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MongoDb")
public class MongoDbDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{11,22,33,44,55};
    }
}
