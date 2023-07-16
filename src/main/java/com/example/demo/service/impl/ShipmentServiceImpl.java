package com.example.demo.service.impl;

import com.example.demo.model.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public String saveShipment(Shipment newShipment) {
		shipmentRepository.save(newShipment);
		return "Created";
	}

	@Override
	public List<Shipment> getAllShipments() {
		return shipmentRepository.findAll();
	}

	@Override
	public String updateShipment(Shipment newShipment, long id) {
		shipmentRepository.findById(id).map((shipment) -> {
			shipment.setLocation(newShipment.getLocation());
			shipment.setQuantity(newShipment.getQuantity());
			shipment.setTimestamp(newShipment.getTimestamp());
			shipment.setProductId(newShipment.getProductId());
			return shipmentRepository.save(shipment);
		}).orElseThrow(() -> new RuntimeException("Shipment not found for id " + id));

		return "Updated";
	}

	@Override
	public String deleteShipment(long id) {
		if(!shipmentRepository.existsById(id))
			throw new RuntimeException("Shipment not found for id " + id);

		shipmentRepository.deleteById(id);
		return "Deleted";
	}
}
