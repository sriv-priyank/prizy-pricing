package com.prizy.store.domain.repository;

import com.prizy.store.domain.entity.StorePrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StorePriceRepository extends CrudRepository<StorePrice, String> {
}
