package com.prizy.product.pricing.service.impl;

import com.prizy.product.pricing.annotation.PricingStrategy;
import com.prizy.product.pricing.enumeration.StrategyName;
import com.prizy.product.pricing.service.PricingService;


@PricingStrategy(strategyName = StrategyName.IDEAL)
public class IdealPricingServiceImpl implements PricingService {

    @Override
    public void compute() {

    }
}
