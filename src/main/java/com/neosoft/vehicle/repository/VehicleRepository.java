package com.neosoft.vehicle.repository;

import com.neosoft.vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    List<Vehicle> findByFuelType(String type);

    List<Vehicle> findByBrand(String brand);

    Vehicle findVehicleByName(String name);

    // List<Vehicle> findByType(String type);
}
