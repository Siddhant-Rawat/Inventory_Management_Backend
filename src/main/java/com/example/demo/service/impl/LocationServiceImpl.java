package com.example.demo.service.impl;

import com.example.demo.model.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public String saveLocation(Location newLocation) {
		locationRepository.save(newLocation);
		return "Created";
	}

	@Override
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	@Override
	public String updateLocation(Location newLocation, long id) {
		locationRepository.findById(id).map((location) -> {
			location.setAddress(newLocation.getAddress());
			location.setName(newLocation.getName());
			location.setContact(newLocation.getContact());
			return locationRepository.save(location);
		}).orElseThrow(() -> new RuntimeException("Location not found for id " + id));

		return "Updated";
	}

	@Override
	public String deleteLocation(long id) {
		if(!locationRepository.existsById(id))
			throw new RuntimeException("Location not found for id " + id);

		locationRepository.deleteById(id);
		return "Deleted";
	}
}
