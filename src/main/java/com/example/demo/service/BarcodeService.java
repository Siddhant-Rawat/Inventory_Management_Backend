package com.example.demo.service;

import com.example.demo.model.Barcode;
import com.example.demo.model.Inventory;

import java.util.List;

public interface BarcodeService {

	String saveBarcode(Barcode newBarcode);
	List<Barcode> getAllBarcodes();
	String updateBarcode(Barcode newBarcode, long id);
	String deleteBarcode(long id);
}
