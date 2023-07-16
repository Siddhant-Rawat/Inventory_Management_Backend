package com.example.demo.controller;

import com.example.demo.model.Barcode;
import com.example.demo.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class BarcodeController {

	@Autowired
	private BarcodeService barcodeService;

	@PostMapping("/barcode-scanners")
	String saveBarcode(@RequestBody Barcode newBarcode) {
		return barcodeService.saveBarcode(newBarcode);
	}

	@GetMapping("/barcode-scanners")
	List<Barcode> getAllBarcodes() {
		return barcodeService.getAllBarcodes();
	}

	@PutMapping("/barcode-scanners/{id}")
	String updateBarcode(@RequestBody Barcode newBarcode, @PathVariable long id) {
		return barcodeService.updateBarcode(newBarcode, id);
	}

	@DeleteMapping("/barcode-scanners/{id}")
	String deleteBarcode(@PathVariable long id) {
		return barcodeService.deleteBarcode(id);
	}
}
