package com.prizy.product.pricing.controller.api;

import org.springframework.http.ResponseEntity;

public interface JobsAPI {

    ResponseEntity<Void> startPriceCalculatorJob(String command);
}
