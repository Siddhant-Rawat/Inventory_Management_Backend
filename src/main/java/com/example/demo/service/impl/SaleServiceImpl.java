package com.example.demo.service.impl;

import com.example.demo.model.Sale;
import com.example.demo.repository.SaleRepository;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Override
	public String saveSale(Sale newSale) {
		saleRepository.save(newSale);
		return "Created";
	}

	@Override
	public List<Sale> getAllSales() {
		return saleRepository.findAll();
	}

	@Override
	public String updateSale(Sale newSale, long id) {
		saleRepository.findById(id).map((sale) -> {
			sale.setQuantity(newSale.getQuantity());
			sale.setPrice(newSale.getPrice());
			sale.setTimestamp(newSale.getTimestamp());
			sale.setProductId(newSale.getProductId());
			return saleRepository.save(sale);
		}).orElseThrow(() -> new RuntimeException("Sale not found for id " + id));

		return "Updated";
	}

	@Override
	public String deleteSale(long id) {
		if(!saleRepository.existsById(id))
			throw new RuntimeException("Sale not found for id " + id);

		saleRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public Sale getReportById(long id) {
		if(!saleRepository.existsById(id))
			throw new RuntimeException("Report not found for Product Id " + id);

		return saleRepository.findById(id).get();
	}
}
