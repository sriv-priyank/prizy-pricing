package com.prizy.product.jobs;

import com.prizy.product.domain.repository.PricingDetailsRepository;
import com.prizy.product.factory.PricingStrategyFactory;
import com.prizy.product.service.ProductService;
import com.prizy.store.service.StorePriceService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PriceCalculationJobTest {

    @InjectMocks
    private PriceCalculationJob priceCalculationJob;

    private final int threadCount = 2;

    @Mock
    private PricingStrategyFactory pricingStrategyFactory;

    @Mock
    private ProductService productService;

    @Mock
    private StorePriceService storePriceService;

    @Mock
    private PricingDetailsRepository pricingDetailsRepository;
}
