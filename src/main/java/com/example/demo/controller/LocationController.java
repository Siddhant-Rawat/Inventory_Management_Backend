package com.example.demo.controller;

import com.example.demo.model.Location;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/locations")
	String newLocation(@RequestBody Location newLocation) {
		return locationService.saveLocation(newLocation);
	}

	@GetMapping("/locations")
	List<Location> getAllLocations() {
		return locationService.getAllLocations();
	}

	@PutMapping("/locations/{id}")
	String updateLocation(@RequestBody Location newLocation, @PathVariable long id) {
		return locationService.updateLocation(newLocation, id);
	}

	@DeleteMapping("/locations/{id}")
	String deleteLocation(@PathVariable long id) {
		return locationService.deleteLocation(id);
	}
}
