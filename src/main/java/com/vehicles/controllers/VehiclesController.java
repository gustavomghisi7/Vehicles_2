package com.vehicles.controllers;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/")
public class VehiclesController {
	
	@Autowired
	VehiclesRepository repo;
	
	@GetMapping
	public String home() {
		return "Welcome to home page";
	}
	
	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicles>> getVehicle() {
		List<Vehicles> vehicles = (List<Vehicles>) repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(vehicles);
	}
	
	@GetMapping("/vehicle/{idvehicle}")
	public ResponseEntity<Vehicles> getVehicleById(@PathVariable("idvehicle") Long idvehicle) {
		Optional<Vehicles> vehicle = repo.findById(idvehicle);
		return vehicle.isPresent() ?
				ResponseEntity.ok(vehicle.get()) :
				ResponseEntity.notFound().build();
	}
	
	@PostMapping("/vehicle")
	public ResponseEntity<Vehicles> postVehicle(@RequestBody Vehicles vehicle) {
		Vehicles vh = repo.save(vehicle);
		return ResponseEntity.status(HttpStatus.CREATED).body(vh);
	}
	
	@DeleteMapping("/vehicle/{idvehicle}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable("idvehicle") Long idvehicle) {
		repo.deleteById(idvehicle);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/vehicle/{idvehicle}")
	public ResponseEntity<Vehicles> updateContact(@PathVariable("idvehicle")
		Long idvehicle, @RequestBody Vehicles vehicle) {
		return ResponseEntity.ok(repo.save(vehicle));
	}
	
	
}
