package com.prizy.product.pricing.controller;

import com.prizy.product.pricing.controller.api.JobsAPI;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/v1/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
public class JobsController implements JobsAPI {

    @PostMapping(value = "/priceCalculator", params = { "command" })
    @Override
    public ResponseEntity<Void> startPriceCalculatorJob(@RequestParam String command) {
        return null;
    }
}
