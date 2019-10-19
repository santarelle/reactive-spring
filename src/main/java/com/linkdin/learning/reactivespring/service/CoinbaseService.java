package com.linkdin.learning.reactivespring.service;

import com.linkdin.learning.reactivespring.model.CoinBaseResponse;
import reactor.core.publisher.Mono;

public interface CoinbaseService {

    Mono<CoinBaseResponse> getCryptoPrice(String priceName);
}
