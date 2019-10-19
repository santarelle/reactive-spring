package com.linkdin.learning.reactivespring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/purchase/v1")
public class PurchaseController {

    @PostMapping(value = "/{name}")
    public Mono<Object> createPurchase(@PathVariable("name") String name) {
        return Mono.fromSupplier(() -> new Object());
    }
}
