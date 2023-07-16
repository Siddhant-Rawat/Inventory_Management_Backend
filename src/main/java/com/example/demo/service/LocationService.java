package com.example.demo.service;

import com.example.demo.model.Location;
import com.example.demo.model.Product;

import java.util.List;

public interface LocationService {

	String saveLocation(Location location);
	List<Location> getAllLocations();
	String updateLocation(Location location, long id);
	String deleteLocation(long id);
}
