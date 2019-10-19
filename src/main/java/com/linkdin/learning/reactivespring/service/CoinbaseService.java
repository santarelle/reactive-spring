package com.linkdin.learning.reactivespring.service;

import com.linkdin.learning.reactivespring.model.CoinBaseResponse;
import com.linkdin.learning.reactivespring.model.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoinbaseService {

    Mono<CoinBaseResponse> getCryptoPrice(String priceName);

    Mono<Purchase> createPurchase(String priceName);

    Mono<Purchase> getPurchaseById(String id);

    Flux<Purchase> listAllPurchases();
}
