package com.linkdin.learning.reactivespring.controller;

import com.linkdin.learning.reactivespring.model.Purchase;
import com.linkdin.learning.reactivespring.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class PurchaseHandler {

    @Autowired
    private CoinbaseService coinbaseService;

    public Mono<ServerResponse> listPurchases(ServerRequest request) {
        final Mono<Purchase> purchase = coinbaseService.getPurchaseById(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchase, Purchase.class);
    }

    public Mono<ServerResponse> listAllPurchases(ServerRequest request) {
        final Flux<Purchase> flux = coinbaseService.listAllPurchases();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(flux.collectList(), new ParameterizedTypeReference<List<Purchase>>() {
                });
    }
}
