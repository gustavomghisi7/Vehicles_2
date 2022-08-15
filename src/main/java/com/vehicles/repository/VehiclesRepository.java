package com.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicles.entity.Vehicles;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {

}
