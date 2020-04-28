package com.haulmont.webfluxdemo.async.repo;

import com.haulmont.webfluxdemo.dto.Cat;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CatRepo {
    Set<Cat> catSet = new HashSet<>();

    public Flux<Cat> getAllCats() {
        return Flux.defer(() -> Flux.fromIterable(createCats()));
    }

    private Set<Cat> createCats() {
        if (catSet.isEmpty()) {
            Cat murzyk = new Cat("Murzyk", 1);
            Cat musia = new Cat("Musia", 2);
            Cat pushok = new Cat("Pushok", 3);
            catSet.add(murzyk);
            catSet.add(musia);
            catSet.add(pushok);
        }
        return catSet;
    }
}
