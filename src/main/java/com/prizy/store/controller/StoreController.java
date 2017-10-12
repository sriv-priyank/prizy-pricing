package com.prizy.store.controller;

import com.prizy.store.controller.api.StoreAPI;
import com.prizy.store.service.StoreService;
import com.prizy.store.vo.StorePriceVO;
import com.prizy.store.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1/store", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreController implements StoreAPI {

    private StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<StoreVO>> findAllStores() {
        return ResponseEntity.ok(storeService.findAllStores());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Void> createStore(@RequestBody StoreVO storeVO) {
        storeService.createStore(storeVO);
        return null;
    }

    @GetMapping(value = "/{storeId}")
    @Override
    public ResponseEntity<StoreVO> findStore(@PathVariable String storeId) {
        return ResponseEntity.ok(storeService.findStore(storeId));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Void> updateStore(@RequestBody StoreVO storeVO) {
        return null;
    }

    @DeleteMapping
    @Override
    public ResponseEntity<StoreVO> deleteStore(String storeId) {
        return ResponseEntity.ok(storeService.deleteStore(storeId));
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<StorePriceVO> saveStorePrice(@RequestBody StorePriceVO storePriceVO) {
        storeService.saveStorePrice(storePriceVO);
        return null;
    }
}
