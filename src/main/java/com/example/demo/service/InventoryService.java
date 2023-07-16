package com.example.demo.service;

import com.example.demo.model.Inventory;

import java.util.List;

public interface InventoryService {

	String saveInventory(Inventory inventory);
	List<Inventory> getAllInventories();
	String updateInventory(Inventory inventory, long id);
	String deleteInventory(long id);
}

