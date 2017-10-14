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
        int lo, hi;
        if (priceList.size() < 5) {
            lo = 0;
            hi = priceList.size();
        } else {
            lo = 2;
            hi = priceList.size() - 2;
        }

        for (int i = lo; i < hi; i++) {
            sum += priceList.get(i);
        }

        Double avg = sum / (hi - lo);   // size = hi - lo
        return 1.2 * avg;
    }
}
