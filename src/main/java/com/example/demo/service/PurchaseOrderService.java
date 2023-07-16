package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

	String saveOrder(PurchaseOrder order);
	List<PurchaseOrder> getAllOrders();
	String updateOrder(PurchaseOrder order, long id);
	String deleteOrder(long id);
}
