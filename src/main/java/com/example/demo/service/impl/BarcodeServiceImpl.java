package com.example.demo.service.impl;

import com.example.demo.model.Barcode;
import com.example.demo.repository.BarcodeRepository;
import com.example.demo.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarcodeServiceImpl implements BarcodeService {

	@Autowired
	private BarcodeRepository barcodeRepository;

	@Override
	public String saveBarcode(Barcode newBarcode) {
		barcodeRepository.save(newBarcode);
		return "Created";
	}

	@Override
	public List<Barcode> getAllBarcodes() {
		return barcodeRepository.findAll();
	}

	@Override
	public String updateBarcode(Barcode newBarcode, long id) {
		barcodeRepository.findById(id).map((barcode) -> {
			barcode.setName(newBarcode.getName());
			barcode.setLocation(newBarcode.getLocation());
			return barcodeRepository.save(barcode);
		}).orElseThrow(() -> new RuntimeException("Barcode not found for id " + id));

		return "Updated";
	}

	@Override
	public String deleteBarcode(long id) {
		if(!barcodeRepository.existsById(id))
			throw new RuntimeException("Barcode not found for id " + id);

		barcodeRepository.deleteById(id);
		return "Deleted";
	}
}
