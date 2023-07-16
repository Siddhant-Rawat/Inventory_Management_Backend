package com.example.demo.controller;

import com.example.demo.model.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class ShipmentController {

	@Autowired
	private ShipmentService shipmentService;

	@PostMapping("/shipment")
	String newShipment(@RequestBody Shipment newShipment) {
		return shipmentService.saveShipment(newShipment);
	}

	@GetMapping("/shipment")
	List<Shipment> getAllShipments() {
		return shipmentService.getAllShipments();
	}

	@PutMapping("/shipment")
	String updateShipment(@RequestBody Shipment newShipment, @RequestParam("id") long id) {
		return shipmentService.updateShipment(newShipment, id);
	}

	@DeleteMapping("/shipment")
	String deleteShipment(@RequestParam("id") long id) {
		return shipmentService.deleteShipment(id);
	}
}
