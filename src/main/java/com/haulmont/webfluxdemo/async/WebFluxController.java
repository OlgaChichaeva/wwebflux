package com.haulmont.webfluxdemo.async;

import com.haulmont.webfluxdemo.async.service.CatService;
import com.haulmont.webfluxdemo.dto.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/test")
public class WebFluxController {

    @Autowired
    CatService service;

    @RequestMapping("/cats")
    private Flux<Cat> getCats() {
        return service.getAllCats();
    }

    @RequestMapping("/averageAge")
    private Mono<Double> getAverageAge() {
        Flux<Cat> cats = WebClient.create()
                .get()
                .uri(URI.create("http://localhost:8080/test/cats"))
                .retrieve()
                .bodyToFlux(Cat.class);

        return service.average(cats);
    }
}
