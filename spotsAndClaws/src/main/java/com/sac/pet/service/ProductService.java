package com.sac.pet.service;

import com.sac.pet.model.Product;

public interface ProductService {
    Product createProduct(Product product);
    String updateProduct(Long id, Product updatedProduct);
    Product findProductByName(String name);
    void deleteProductById(Long id);
	boolean existProduct(Long product);
	String changeProductStatus(Long id, Product product);
}
