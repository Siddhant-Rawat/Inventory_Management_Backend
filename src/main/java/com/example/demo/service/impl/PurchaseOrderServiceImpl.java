package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Override
	public String saveOrder(PurchaseOrder newOrder) {
		purchaseOrderRepository.save(newOrder);
		return "Created";
	}

	@Override
	public List<PurchaseOrder> getAllOrders() {
		return purchaseOrderRepository.findAll();
	}

	@Override
	public String updateOrder(PurchaseOrder newOrder, long id) {
		purchaseOrderRepository.findById(id).map((order) -> {
			order.setQuantity(newOrder.getQuantity());
			order.setSupplier(newOrder.getSupplier());
			order.setTimestamp(newOrder.getTimestamp());
			order.setProductId(newOrder.getProductId());
			return purchaseOrderRepository.save(order);
		}).orElseThrow(() -> new RuntimeException("Order not found for id " + id));

		return "Updated";
	}

	@Override
	public String deleteOrder(long id) {
		if(!purchaseOrderRepository.existsById(id)) {
			throw new RuntimeException("Order not found for id " + id);
		}

		purchaseOrderRepository.deleteById(id);
		return "Deleted";
	}
}
