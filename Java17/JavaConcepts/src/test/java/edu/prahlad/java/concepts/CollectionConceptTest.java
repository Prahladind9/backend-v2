package edu.prahlad.java.concepts;

import edu.prahlad.java.concepts.CollectionConcept.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CollectionConceptTest {

    @Test
    void given_collectionList_then_printList(){
        Collection<Product> products = new ArrayList<>();
        var door = new Product("Door", 35);
        products.add(door);
        var panel = new Product("Panel", 25);
        products.add(panel);
        var window = new Product("Window", 10);
        products.add(window);
        var glass = new Product("Glass", 8);
        products.add(glass);

        log.info("productList:{}", products);
        log.trace("forEach imple");
        var iterator = products.iterator();
        while (iterator.hasNext()){
            var product = iterator.next();
            log.debug("IteratorPrint:{}", product);
            if(product.weight() > 1000) iterator.remove();
        }


        log.info("size:{}", products.size());
        log.info("isEmpty:{}", products.isEmpty());
        log.info("contains:{}", products.contains(window));
        log.info("remove Window:{}", products.remove(window));
        log.info("productList:{}", products);


        Collection<Product> toRemove = new ArrayList<>();
        toRemove.add(door);
        toRemove.add(panel);
        log.info("toRemove productList:{}", toRemove);

        products.removeAll(toRemove);
        log.info("after remove productList:{}", products);

    }

    @Test
    void given_collectionHashMap_then_shouldPerformOperations(){
        var defaultProduct = new Product( "Whatever cusomter wants", 100);

        var idToProduct = new HashMap<Integer, Product>();
        idToProduct.put(1, new Product("Door", 35));
        idToProduct.put(2, new Product("Panel", 25));
        idToProduct.put(3, new Product("Glass", 5));

        log.info("vals:{}", idToProduct.keySet());

        log.info("when key value not found return the default product");
        assertEquals(idToProduct.getOrDefault(4, defaultProduct), defaultProduct);

        log.info("before replaceAll idToProduct:{}", idToProduct);
        idToProduct.replaceAll((id, product) -> new Product(product.name(), product.weight() + 10));
        log.info("after replaceAll idToProduct:{}", idToProduct);

        var pool = new Product("pool", 150);

        idToProduct.computeIfAbsent(5, id -> pool);
        assertEquals(idToProduct.get(5), pool);

        idToProduct.forEach((id, product) -> log.trace(product.name() + " has an weight of lb:{}", product.weight()));
    }
}
