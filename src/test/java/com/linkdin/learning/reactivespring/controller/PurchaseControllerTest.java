package com.linkdin.learning.reactivespring.controller;

import com.linkdin.learning.reactivespring.model.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PurchaseControllerTest {

    @Autowired
    ApplicationContext context;

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(this.context).build();
    }

    @Test
    void createPurchase() {
        webTestClient.get()
                .uri("/coin/purchase/v1/{id}", 123)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Purchase.class);
    }
}