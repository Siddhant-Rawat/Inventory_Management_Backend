package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public String saveProduct(Product product) {
		productRepository.save(product);
		return "Created";
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public String updateProduct(Product newProduct, long id) {
		productRepository.findById(id).map(product -> {
			product.setName(newProduct.getName());
			product.setDescription(newProduct.getDescription());
			product.setPrice(newProduct.getPrice());
			product.setQuantity(newProduct.getQuantity());
			product.setLocation(newProduct.getLocation());
			product.setBarcode(newProduct.getBarcode());
			return productRepository.save(product);
		}).orElseThrow(() -> new RuntimeException("Product not found for id " + id));

		return "Updated";
	}

	@Override
	public String deleteProduct(long id) {
		if (!productRepository.existsById(id)) {
			throw new RuntimeException("Product not found for id " + id);
		}

		productRepository.deleteById(id);
		return "Deleted";
	}

}
