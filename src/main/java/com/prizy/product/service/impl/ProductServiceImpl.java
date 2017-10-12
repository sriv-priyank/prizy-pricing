package com.prizy.product.service.impl;

import com.prizy.product.service.ProductService;
import com.prizy.product.vo.PricingDetailsVO;
import com.prizy.product.vo.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Override
    public List<ProductVO> findAllProducts() {
        return null;
    }

    @Override
    public void createProduct(ProductVO productVO) {

    }

    @Override
    public ProductVO findProduct(String productId) {
        return null;
    }

    @Override
    public void updateProduct(ProductVO productVO) {

    }

    @Override
    public ProductVO deleteProduct(String productId) {
        return null;
    }

    @Override
    public PricingDetailsVO getPrices(String productId) {
        return null;
    }
}
