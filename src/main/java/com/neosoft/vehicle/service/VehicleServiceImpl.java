package com.neosoft.vehicle.service;

import com.neosoft.vehicle.entity.Vehicle;
import com.neosoft.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public CompletableFuture<List<Vehicle>> getAllVehicle() {

        return CompletableFuture.completedFuture(vehicleRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<List<Vehicle>> getVehicleByBrand(String brand) {
        return CompletableFuture.completedFuture(vehicleRepository.findByBrand(brand));
    }

    @Async
    @Override
    public CompletableFuture<Vehicle> getVehicleDetails(String name) {
        return CompletableFuture.completedFuture(vehicleRepository.findVehicleByName(name));
    }

    @Async
    @Override
    public CompletableFuture<List<Vehicle>> getVehicleByType(String type) {
        return CompletableFuture.completedFuture(vehicleRepository.findByFuelType(type));
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void removeVehicle(Integer id) {
        vehicleRepository.deleteById(id);
        System.out.println("Vehicle is deleted of id "+id);
    }
}
