package com.prizy.store.service;

import com.prizy.store.domain.repository.StorePriceRepository;
import com.prizy.store.mapper.StorePriceToStorePriceVOMapper;
import com.prizy.store.mapper.StorePriceVOToStorePriceMapper;
import com.prizy.store.service.impl.StorePriceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StorePriceServiceTest {

    @InjectMocks
    private StorePriceServiceImpl storePriceService;

    @Mock
    private StorePriceRepository storePriceRepository;

    @Mock
    private StorePriceToStorePriceVOMapper storePriceToStorePriceVOMapper;

    @Mock
    private StorePriceVOToStorePriceMapper storePriceVOToStorePriceMapper;

    @Test
    public void testCreateStorePrice() {

    }

    @Test
    public void testFindByProductId() {

    }
}
