package com.prizy.store.controller;

import com.prizy.store.service.StorePriceService;
import com.prizy.store.service.StoreService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StoreControllerTest {

    @InjectMocks
    private StoreController storeController;

    @Mock
    private StoreService storeService;

    @Mock
    private StorePriceService storePriceService;
}
