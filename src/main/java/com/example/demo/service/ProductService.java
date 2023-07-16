package com.example.demo.service;


import com.example.demo.model.Product;

import java.util.List;


public interface ProductService {

	String saveProduct(Product product);

	List<Product> getAllProducts();

	String updateProduct(Product product, long id);

	String deleteProduct(long id);
}
