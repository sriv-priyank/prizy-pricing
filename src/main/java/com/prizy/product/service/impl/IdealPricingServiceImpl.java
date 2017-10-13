package com.prizy.product.service.impl;

import com.prizy.product.annotation.PricingStrategy;
import com.prizy.product.enumeration.StrategyName;
import com.prizy.product.service.PricingService;

import java.util.Collections;
import java.util.List;


@PricingStrategy(strategyName = StrategyName.IDEAL)
public class IdealPricingServiceImpl implements PricingService {

    @Override
    public Double compute(List<Double> priceList) {
        return compute(priceList, false);
    }

    @Override
    public Double compute(List<Double> priceList, boolean sortedAscending) {
        if (!sortedAscending) {
            Collections.sort(priceList);
        }
        Double sum = 0d;

        for (int i = 2; i < priceList.size() - 2; i++) {
            sum += priceList.get(i);
        }

        Double avg = sum / (priceList.size() - 4);
        return 1.2 * avg;
    }
}
