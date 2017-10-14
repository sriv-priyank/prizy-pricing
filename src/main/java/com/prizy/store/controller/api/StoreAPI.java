package com.prizy.store.controller.api;

import com.prizy.store.vo.StorePriceVO;
import com.prizy.store.vo.StoreVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StoreAPI {

    ResponseEntity<List<StoreVO>> findAllStores();

    ResponseEntity<Void> createStore(StoreVO storeVO);

    ResponseEntity<StoreVO> findStore(String storeId);

    ResponseEntity<Void> updateStore(String storeId, StoreVO storeVO);

    ResponseEntity<StoreVO> deleteStore(String storeId);

    ResponseEntity<StorePriceVO> saveStorePrice(StorePriceVO storePriceVO);
}
