package com.neosoft.vehicle.service;

import com.neosoft.vehicle.entity.Vehicle;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface VehicleService {

    public CompletableFuture<List<Vehicle>> getAllVehicle();
    public CompletableFuture<List<Vehicle>> getVehicleByBrand(String brand);
    public CompletableFuture<Vehicle> getVehicleDetails(String name);
    public CompletableFuture<List<Vehicle>> getVehicleByType(String type);

    public Vehicle saveVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Vehicle vehicle);
    public void removeVehicle(Integer id);


}
