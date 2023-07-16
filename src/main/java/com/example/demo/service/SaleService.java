package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.Sale;

import java.util.List;

public interface SaleService {

	String saveSale(Sale newSale);

	List<Sale> getAllSales();

	String updateSale(Sale newSale, long id);

	String deleteSale(long id);

	Sale getReportById(long id);
}
