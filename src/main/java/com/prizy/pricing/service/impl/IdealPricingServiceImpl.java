package com.prizy.pricing.service.impl;

import com.prizy.pricing.annotation.PricingStrategy;
import com.prizy.pricing.enumeration.StrategyName;
import com.prizy.pricing.service.PricingService;


@PricingStrategy(strategyName = StrategyName.IDEAL)
public class IdealPricingServiceImpl implements PricingService {

    @Override
    public void compute() {

    }
}
