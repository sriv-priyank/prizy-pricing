package com.prizy.product.controller;

import com.prizy.product.controller.api.ProductAPI;
import com.prizy.product.service.ProductService;
import com.prizy.product.vo.PricingDetailsVO;
import com.prizy.product.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController implements ProductAPI {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductVO>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Void> createProduct(@RequestBody ProductVO productVO) {
        productService.createProduct(productVO);
        return null;
    }

    @GetMapping(value = "/{productId}")
    @Override
    public ResponseEntity<ProductVO> findProduct(@PathVariable String productId) {
        return ResponseEntity.ok(productService.findProduct(productId));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Void> updateProduct(@RequestBody ProductVO productVO) {
        productService.updateProduct(productVO);
        return null;
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ProductVO> deleteProduct(String productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }

    @GetMapping(value = "/{productId}/prices")
    @Override
    public ResponseEntity<PricingDetailsVO> getPrices(@PathVariable String productId) {
        return ResponseEntity.ok(productService.getPrices(productId));
    }
}
