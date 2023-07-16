package com.example.demo.controller;

import com.example.demo.model.Inventory;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/inventory")
	String newInventory(@RequestBody Inventory newInventory) {
		return inventoryService.saveInventory(newInventory);
	}

	@GetMapping("/inventory")
	List<Inventory> displayInventories() {
		return inventoryService.getAllInventories();
	}

	@PutMapping("/inventory/{id}")
	String updateInventory(@RequestBody Inventory newInventory, @PathVariable long id) {
		return inventoryService.updateInventory(newInventory, id);
	}

	@DeleteMapping("/inventory/{id}")
	String deleteInventory(@PathVariable long id) {
		return inventoryService.deleteInventory(id);
	}

}
