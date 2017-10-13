package com.prizy.pricing.controller.api;

import org.springframework.http.ResponseEntity;

public interface JobsAPI {

    ResponseEntity<Void> startPriceCalculatorJob(String command);
}
