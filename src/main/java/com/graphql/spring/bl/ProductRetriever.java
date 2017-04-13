package com.graphql.spring.bl;

import com.graphql.spring.domain.Product;
import com.graphql.spring.jpa.ProductRepository;
import com.graphql.spring.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRetriever {

    @Autowired
    ProductRepository productRepository;


    ProductMapper productMapper;

    public List<Product> getProducts()
    {
        List<com.graphql.spring.jpa.Product> all = productRepository.findAll();
        List<com.graphql.spring.domain.Product> products = productMapper.productsToProductsApi(all);
        return products;
    }

    public List<Product> getProductsByStoreId(int store_id)
    {
        List<com.graphql.spring.jpa.Product> all = productRepository.findByStore_id(store_id);
        List<com.graphql.spring.domain.Product> products = productMapper.productsToProductsApi(all);
        return products;
    }

    public Product getProduct(int product_id)
    {
        com.graphql.spring.jpa.Product all = productRepository.findByid(product_id);
        com.graphql.spring.domain.Product product = productMapper.productToProductApi(all);
        return product;
    }
}


