package com.prizy.store.service;


import com.prizy.store.vo.StoreVO;

import java.util.List;

public interface StoreService {

    List<StoreVO> findAllStores();

    StoreVO createStore(StoreVO storeVO);

    StoreVO findStore(String storeId);

    void updateStore(StoreVO storeVO);

    StoreVO deleteStore(String storeId);
}
