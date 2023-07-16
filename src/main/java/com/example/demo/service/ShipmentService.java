package com.example.demo.service;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.Shipment;

import java.util.List;

public interface ShipmentService {

	String saveShipment(Shipment shipment);
	List<Shipment> getAllShipments();
	String updateShipment(Shipment shipment, long id);
	String deleteShipment(long id);
}
