package com.prizy.store.service.impl;

import com.prizy.store.service.StoreService;
import com.prizy.store.vo.StorePriceVO;
import com.prizy.store.vo.StoreVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
final class StoreServiceImpl implements StoreService {

    private Logger LOG = LoggerFactory.getLogger(StoreService.class);

    @Override
    public List<StoreVO> findAllStores() {
        return null;
    }

    @Override
    public void createStore(StoreVO storeVO) {

    }

    @Override
    public StoreVO findStore(String storeId) {
        return null;
    }

    @Override
    public void updateStore(StoreVO storeVO) {

    }

    @Override
    public StoreVO deleteStore(String storeId) {
        return null;
    }

    @Override
    public StorePriceVO saveStorePrice(StorePriceVO storePriceVO) {
        return null;
    }
}
