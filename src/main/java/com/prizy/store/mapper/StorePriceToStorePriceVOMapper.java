package com.prizy.store.mapper;

import com.prizy.product.domain.entity.Product;
import com.prizy.store.domain.entity.Store;
import com.prizy.store.domain.entity.StorePrice;
import com.prizy.store.vo.StorePriceVO;
import org.springframework.stereotype.Component;


@Component
public class StorePriceToStorePriceVOMapper {

    public StorePriceVO map(StorePrice storePrice) {
        StorePriceVO storePriceVO = new StorePriceVO();
        storePriceVO.setId(storePrice.getId());

        if (storePrice.getProduct() != null) {
            storePriceVO.setProduct(storePrice.getProduct().getId());
        }

        if (storePrice.getStore() != null) {
            storePriceVO.setStore(storePrice.getStore().getId());
        }

        storePriceVO.setNotes(storePrice.getNotes());
        storePriceVO.setCreated(storePrice.getCreated());

        return storePriceVO;
    }

}
