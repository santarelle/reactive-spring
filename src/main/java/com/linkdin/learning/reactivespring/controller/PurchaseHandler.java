package com.linkdin.learning.reactivespring.controller;

import com.linkdin.learning.reactivespring.model.Purchase;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class PurchaseHandler {

    public Mono<ServerResponse> listPurchases(ServerRequest request) {
        final Mono<Purchase> purchase = Mono
                .fromSupplier(() -> new Purchase("From functional endpoint", "123", LocalDateTime.now()));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchase, Purchase.class);
    }
}
