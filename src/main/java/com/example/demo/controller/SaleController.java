package com.example.demo.controller;

import com.example.demo.model.Sale;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class SaleController {

	@Autowired
	private SaleService saleService;

	@PostMapping("/sales")
	String saveSale(@RequestBody Sale newSale) {
		return saleService.saveSale(newSale);
	}

	@GetMapping("/sales")
	List<Sale> getAllSales() {
		return saleService.getAllSales();
	}

	@PutMapping("/sales")
	String updateSale(@RequestBody Sale newSale, @RequestParam("id") long id) {
		return saleService.updateSale(newSale, id);
	}

	@DeleteMapping("/sales")
	String deleteSale(@RequestParam("id") long id) {
		return saleService.deleteSale(id);
	}

	@GetMapping("/sales/reports/productid")
	Sale getReportById(@RequestParam("productId") long productId) {
		return saleService.getReportById(productId);
	}
}
