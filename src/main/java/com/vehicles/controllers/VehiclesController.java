package com.vehicles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicles.entity.Vehicles;
import com.vehicles.repository.VehiclesRepository;
import com.vehicles.services.VehicleService;

@RestController
@RequestMapping("/")
public class VehiclesController {
	
	@Autowired
	VehiclesRepository repo;
	
	@Autowired
	VehicleService service;
	
	@GetMapping
	public String home() {
		return "Welcome to home page";
	}
	
	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicles>> getVehicle() {
		List<Vehicles> vehicles = service.consultVehicles();
		return ResponseEntity.status(HttpStatus.OK).body(vehicles);
	}
	
	@GetMapping("/vehicle/{idvehicle}")
	public ResponseEntity<Vehicles> getVehicleById(@PathVariable("idvehicle") Long idvehicle) {
		return ResponseEntity.ok(service.consultVehicleById(idvehicle));
	}
	
	@PostMapping("/vehicle")
	public ResponseEntity<Vehicles> postVehicle(@RequestBody Vehicles vehicle) {
		Vehicles vh = repo.save(vehicle);
		return ResponseEntity.status(HttpStatus.CREATED).body(vh);
	}
	
	@DeleteMapping("/vehicle/{idvehicle}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable("idvehicle") Long idvehicle) {
		service.excludeVehicle(idvehicle);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/vehicle/{idvehicle}")
	public ResponseEntity<Vehicles> updateContact(@PathVariable("idvehicle")
		Long idvehicle, @RequestBody Vehicles vehicle) {
		return ResponseEntity.ok(service.chageVehicle(idvehicle, vehicle));
	}
	
	
}
