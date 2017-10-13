package com.prizy.product.core.controller.api;

import com.prizy.product.core.vo.PricingDetailsVO;
import com.prizy.product.core.vo.ProductVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductAPI {

    ResponseEntity<List<ProductVO>> findAllProducts();

    ResponseEntity<Void> createProduct(ProductVO productVO);

    ResponseEntity<ProductVO> findProduct(String productId);

    ResponseEntity<Void> updateProduct(ProductVO productVO);

    ResponseEntity<ProductVO> deleteProduct(String productId);

    ResponseEntity<PricingDetailsVO> getPrices(String productId);
}
