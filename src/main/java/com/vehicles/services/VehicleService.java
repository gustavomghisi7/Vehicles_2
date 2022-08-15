package com.vehicles.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicles.entity.Vehicles;
import com.vehicles.repository.VehiclesRepository;

@Service
public class VehicleService {
	@Autowired
	VehiclesRepository repo;
	
	public Vehicles saved(Vehicles vehicles) {
		return repo.save(vehicles);
	}
	
	public List<Vehicles> consultVehicles(){
		List<Vehicles> vehicles = repo.findAll();
		return vehicles;
	}
	
	public Vehicles consultVehicleById(Long idvehicle) {
		Optional<Vehicles> opvehicle = repo.findById(idvehicle);
		Vehicles vh = opvehicle.orElseThrow(
				() -> new EntityNotFoundException("Vehicle not found"));
		return vh;
	}
	
	public void excludeVehicle(Long idvehicle) {
		Vehicles vh = consultVehicleById(idvehicle);
		repo.delete(vh);
	}
	
	public Vehicles chageVehicle(Long idvehicle, Vehicles vehicle) {
		Vehicles vh = consultVehicleById(idvehicle);
		vh.setCarModel(vehicle.getCarModel());
		vh.setCarBrand(vehicle.getCarBrand());
		vh.setLicensePlate(vehicle.getLicensePlate());
		return repo.save(vh);
		
	}

}
