package com.haulmont.webfluxdemo.async.service;

import com.haulmont.webfluxdemo.async.repo.CatRepo;
import com.haulmont.webfluxdemo.dto.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class CatService {
    @Autowired
    CatRepo repo;

    public Flux<Cat> getAllCats() {
        return repo.getAllCats();
    }

    public Mono<Double> average(Flux<Cat> cats) {
        return cats.collect(Collectors.averagingInt(Cat::getAge));
    }
}
