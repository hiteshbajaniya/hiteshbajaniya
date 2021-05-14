package com.neosoft.vehicle.service;

import com.neosoft.vehicle.entity.Vehicle;
import com.neosoft.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Async
    @Override
    public List<Vehicle> getVehicleByBrand(String brand) {
        return vehicleRepository.findByBrand(brand);
    }

    @Async
    @Override
    public Vehicle getVehicleDetails(String name) {
        return vehicleRepository.findVehicleByName(name);
    }

    @Async
    @Override
    public List<Vehicle> getVehicleByType(String type) {
        return vehicleRepository.findByFuelType(type);
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
