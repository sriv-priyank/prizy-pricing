package com.prizy.store.service.impl;

import com.prizy.store.domain.entity.StorePrice;
import com.prizy.store.domain.repository.StorePriceRepository;
import com.prizy.store.mapper.StorePriceToStorePriceVOMapper;
import com.prizy.store.mapper.StorePriceVOToStorePriceMapper;
import com.prizy.store.service.StorePriceService;
import com.prizy.store.vo.StorePriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class StorePriceServiceImpl implements StorePriceService {

    @Override
    public StorePriceVO saveStorePrice(StorePriceVO storePriceVO) {
        storePriceVO.setId(UUID.randomUUID().toString());
        StorePrice storePrice = storePriceRepository.save(
                storePriceVOToStorePriceMapper.map(storePriceVO));
        return storePriceToStorePriceVOMapper.map(storePrice);
    }

    @Override
    public List<StorePriceVO> findByProductId(String productId) {
        List<StorePrice> prices = storePriceRepository.findByProductId(productId);
        return storePriceToStorePriceVOMapper.mapList(prices);
    }

    @Autowired
    private StorePriceRepository storePriceRepository;

    @Autowired
    private StorePriceToStorePriceVOMapper storePriceToStorePriceVOMapper;

    @Autowired
    private StorePriceVOToStorePriceMapper storePriceVOToStorePriceMapper;
}
