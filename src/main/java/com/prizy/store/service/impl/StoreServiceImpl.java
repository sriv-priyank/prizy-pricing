package com.prizy.store.service.impl;

import com.prizy.common.exception.RecordNotFoundException;
import com.prizy.store.domain.entity.Store;
import com.prizy.store.domain.repository.StoreRepository;
import com.prizy.store.mapper.StoreToStoreVOMapper;
import com.prizy.store.mapper.StoreVOToStoreMapper;
import com.prizy.store.service.StoreService;
import com.prizy.store.vo.StorePriceVO;
import com.prizy.store.vo.StoreVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class StoreServiceImpl implements StoreService {

    private Logger LOG = LoggerFactory.getLogger(StoreService.class);

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreToStoreVOMapper storeToStoreVOMapper;

    @Autowired
    private StoreVOToStoreMapper storeVOToStoreMapper;


    @Override
    public List<StoreVO> findAllStores() {
        Iterable<Store> entities = storeRepository.findAll();
        return storeToStoreVOMapper.mapList(entities);
    }

    @Override
    public void createStore(StoreVO storeVO) {
        storeVO.setId(UUID.randomUUID().toString());
        storeRepository.save(storeVOToStoreMapper.map(storeVO));
    }

    @Override
    public StoreVO findStore(String storeId) {
        Store store = storeRepository.findOne(storeId);
        if (store == null) {
            throw new RecordNotFoundException("Store not found.");
        }
        return storeToStoreVOMapper.map(store);
    }

    @Override
    public void updateStore(StoreVO storeVO) {
        Store oldStore = storeRepository.findOne(storeVO.getId());
        if (oldStore == null) {
            throw new RecordNotFoundException("Fatal: Cannot update store that doesn't exist.");
        }
        storeRepository.save(storeVOToStoreMapper.map(storeVO));
    }

    @Override
    public StoreVO deleteStore(String storeId) {
        Store store = storeRepository.findOne(storeId);
        if (store == null) {
            throw new RecordNotFoundException("Fatal: Cannot delete store that doesn't exist.");
        }
        storeRepository.delete(store);
        return storeToStoreVOMapper.map(store);
    }

    @Override
    public StorePriceVO saveStorePrice(StorePriceVO storePriceVO) {
        return null;
    }
}
