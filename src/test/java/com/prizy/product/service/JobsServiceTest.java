package com.prizy.product.service;

import com.prizy.product.jobs.PriceCalculationJob;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JobsServiceTest {

    @InjectMocks
    private JobsService jobsService;

    @Mock
    private PriceCalculationJob priceCalculationJob;
}
