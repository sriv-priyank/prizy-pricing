package com.prizy.product.core.service;

import com.prizy.product.core.vo.PricingDetailsVO;
import com.prizy.product.core.vo.ProductVO;

import java.util.List;

public interface ProductService {

    List<ProductVO> findAllProducts();

    ProductVO createProduct(ProductVO productVO);

    ProductVO findProduct(String productId);

    void updateProduct(ProductVO productVO);

    ProductVO deleteProduct(String productId);

    PricingDetailsVO getPrices(String productId);
}
