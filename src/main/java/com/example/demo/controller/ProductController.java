package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin()
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	String newProduct(@RequestBody Product newProduct) {
		return productService.saveProduct(newProduct);
	}

	@GetMapping("/product")
	List<Product> displayProducts() {
		return productService.getAllProducts();
	}

	@PutMapping("/product/{id}")
	String updateProduct(@RequestBody Product newProduct, @PathVariable long id) {
		return productService.updateProduct(newProduct, id);
	}

	@DeleteMapping("/product/{id}")
	String deleteProduct(@PathVariable long id) {
		return productService.deleteProduct(id);
	}
}

