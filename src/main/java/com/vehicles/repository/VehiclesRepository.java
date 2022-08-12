package com.vehicles.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vehicles.entity.Vehicles;

@Repository
public interface VehiclesRepository extends CrudRepository<Vehicles, Long> {

}
