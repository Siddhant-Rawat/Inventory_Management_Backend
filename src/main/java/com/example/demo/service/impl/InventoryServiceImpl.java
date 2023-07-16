package com.example.demo.service.impl;


import java.util.List;

import com.example.demo.model.Inventory;
import com.example.demo.model.Product;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public String saveInventory(Inventory inventory) {

		Product product = inventory.getProduct();

		if (!productRepository.existsById(product.getId())) {
			throw new RuntimeException("Product doesn't exists");
		}

		Product product2 = productRepository.findById(product.getId()).get();

		inventory.setProduct(product2);

		List<Inventory> inventories = product2.getInventory();
		inventories.add(inventory);

		inventoryRepository.save(inventory);

		return "Created";
	}

	@Override
	public List<Inventory> getAllInventories() {
		return inventoryRepository.findAll();
	}

	@Override
	public String updateInventory(Inventory newInventory, long id) {
		inventoryRepository.findById(id).map((inventory) -> {
			inventory.setQuantity(newInventory.getQuantity());
			inventory.setLocation(newInventory.getLocation());
			inventory.setDate(newInventory.getDate());
			return inventoryRepository.save(inventory);
		}).orElseThrow(() -> new RuntimeException("Inventory not found for id " + id));

		return "Updated";
	}

	@Override
	public String deleteInventory(long id) {
		if (!inventoryRepository.existsById(id)) {
			throw new RuntimeException("Inventory not found for id " + id);
		}

		inventoryRepository.deleteById(id);
		return "Deleted";
	}

}

