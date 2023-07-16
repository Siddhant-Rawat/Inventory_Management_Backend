package com.example.demo.controller;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@PostMapping("/purchase-order")
	String newOrder(@RequestBody PurchaseOrder newOrder) {
		return purchaseOrderService.saveOrder(newOrder);
	}

	@GetMapping("/purchase-order")
	List<PurchaseOrder> displayAllOrders() {
		return purchaseOrderService.getAllOrders();
	}

	@PutMapping("/purchase-order/{id}")
	String updateOrder(@RequestBody PurchaseOrder order, @PathVariable long id) {
		return purchaseOrderService.updateOrder(order, id);
	}

	@DeleteMapping("/purchase-order/{id}")
	String deleteOrder(@PathVariable long id) {
		return purchaseOrderService.deleteOrder(id);
	}
}
