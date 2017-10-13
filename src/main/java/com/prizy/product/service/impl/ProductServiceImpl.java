package com.prizy.product.service.impl;

import com.prizy.common.exception.RecordNotFoundException;
import com.prizy.product.domain.entity.PricingDetails;
import com.prizy.product.domain.entity.Product;
import com.prizy.product.domain.repository.PricingDetailsRepository;
import com.prizy.product.domain.repository.ProductRepository;
import com.prizy.product.mapper.ProductToProductVOMapper;
import com.prizy.product.mapper.ProductVOToProductMapper;
import com.prizy.product.service.ProductService;
import com.prizy.product.vo.PricingDetailsVO;
import com.prizy.product.vo.ProductVO;
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
        Product product = productRepository.findOne(productId);
        if (product == null) {
            throw new RecordNotFoundException("Product doesn't exist.");
        }
        PricingDetails pricingDetails = pricingDetailsRepository
                .findLatestByProductId(productId);

        PricingDetailsVO vo = new PricingDetailsVO();
        vo.setProduct(productId);
        vo.setName(product.getProductName());
        vo.setDescription(product.getDescription());

        vo.setIdealPrice(pricingDetails.getIdealPrice());
        vo.setAveragePrice(pricingDetails.getAveragePrice());
        vo.setLowestPrice(pricingDetails.getLowestPrice());
        vo.setHighestPrice(pricingDetails.getHighestPrice());

        return vo;
    }


    @Autowired
    private PricingDetailsRepository pricingDetailsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductToProductVOMapper productToProductVOMapper;

    @Autowired
    private ProductVOToProductMapper productVOToProductMapper;
}
