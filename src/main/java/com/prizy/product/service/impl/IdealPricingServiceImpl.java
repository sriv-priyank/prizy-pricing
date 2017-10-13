package com.prizy.product.service.impl;

import com.prizy.product.annotation.PricingStrategy;
import com.prizy.product.enumeration.StrategyName;
import com.prizy.product.service.PricingService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@PricingStrategy(strategyName = StrategyName.IDEAL)
public class IdealPricingServiceImpl implements PricingService {

    @Override
    public void compute() {

    }

    private Map<String, Double> compute(Map<String, List<Double>> priceMap) {
        Map<String, Double> idealPriceMap = new HashMap<>();
        for (String key : priceMap.keySet()) {
            Double idealPrice = compute(priceMap.get(key));
            idealPriceMap.put(key, idealPrice);
        }
        return idealPriceMap;
    }

    private Double compute(List<Double> prices) {
        Collections.sort(prices);
        Double sum = 0d;

        for (int i = 2; i < prices.size() - 2; i++) {
            sum += prices.get(i);
        }

        Double avg = sum / (prices.size() - 4);
        return 1.2 * avg;
    }
}
