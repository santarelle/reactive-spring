package com.linkdin.learning.reactivespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/price/v1")
public class PriceController {

    @GetMapping(value = "/{name}")
    // TODO: change String to Domain Model type when it's ready
    public Mono<String> getPrice(@PathVariable String name) {

        // TODO: use autowired service bean to get price
        return Mono.fromSupplier(() -> "price");
    }
}
