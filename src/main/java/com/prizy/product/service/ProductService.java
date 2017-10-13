package com.prizy.product.service;

import com.prizy.product.vo.PricingDetailsVO;
import com.prizy.product.vo.ProductVO;

import java.util.List;

public interface ProductService {

    List<ProductVO> findAllProducts();

    ProductVO createProduct(ProductVO productVO);

    ProductVO findProduct(String productId);

    void updateProduct(ProductVO productVO);

    ProductVO deleteProduct(String productId);

    PricingDetailsVO getPrices(String productId);
}
