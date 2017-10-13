package com.prizy.product.core.service.impl;

import com.prizy.common.exception.RecordNotFoundException;
import com.prizy.product.core.domain.entity.Product;
import com.prizy.product.core.domain.repository.ProductRepository;
import com.prizy.product.core.mapper.ProductToProductVOMapper;
import com.prizy.product.core.mapper.ProductVOToProductMapper;
import com.prizy.product.core.service.ProductService;
import com.prizy.product.core.vo.PricingDetailsVO;
import com.prizy.product.core.vo.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService {

    private Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Override
    public List<ProductVO> findAllProducts() {
        Iterable<Product> entities = productRepository.findAll();
        return productToProductVOMapper.mapList(entities);
    }

    @Override
    public ProductVO createProduct(ProductVO productVO) {
        productVO.setId(UUID.randomUUID().toString());
        Product product = productRepository.save(productVOToProductMapper.map(productVO));
        return productToProductVOMapper.map(product);
    }

    @Override
    public ProductVO findProduct(String productId) {
        Product product = productRepository.findOne(productId);
        if (product == null) {
            throw new RecordNotFoundException("Product not found.");
        }
        return productToProductVOMapper.map(product);
    }

    @Override
    public void updateProduct(ProductVO productVO) {
        Product oldProduct = productRepository.findOne(productVO.getId());
        if (oldProduct == null) {
            throw new RecordNotFoundException("Fatal: Cannot update product that doesn't exist.");
        }
        productRepository.save(productVOToProductMapper.map(productVO));
    }

    @Override
    public ProductVO deleteProduct(String productId) {
        Product product = productRepository.findOne(productId);
        if (product == null) {
            throw new RecordNotFoundException("Fatal: Cannot delete product that doesn't exist.");
        }
        productRepository.delete(product);
        return productToProductVOMapper.map(product);
    }

    @Override
    public PricingDetailsVO getPrices(String productId) {
        return null;
    }


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductToProductVOMapper productToProductVOMapper;

    @Autowired
    private ProductVOToProductMapper productVOToProductMapper;
}
