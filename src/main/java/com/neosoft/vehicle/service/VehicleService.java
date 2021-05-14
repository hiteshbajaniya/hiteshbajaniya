package com.neosoft.vehicle.service;

import com.neosoft.vehicle.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> getAllVehicle();
    public List<Vehicle> getVehicleByBrand(String brand);
    public Vehicle getVehicleDetails(String name);
    public List<Vehicle> getVehicleByType(String type);

    public Vehicle saveVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Vehicle vehicle);
    public void removeVehicle(Integer id);


}
