package com.neosoft.vehicle.controller;

import com.neosoft.vehicle.entity.Vehicle;
import com.neosoft.vehicle.service.VehicleService;
import jdk.jfr.internal.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.VetoableChangeListener;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle){
        Vehicle response = vehicleService.saveVehicle(vehicle);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/type/{fuelType}")
    public ResponseEntity<List<Vehicle>> getVehicleByType(@PathVariable("fuelType") String fuelType){

        List<Vehicle> category = vehicleService.getVehicleByType(fuelType);
        return new ResponseEntity<List<Vehicle>>(category, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Vehicle>> getVehicleByBrand(@PathVariable("brand") String brand){

        List<Vehicle> data = vehicleService.getVehicleByBrand(brand);
        return new ResponseEntity<List<Vehicle>>(data, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicle(){
        return new ResponseEntity<List<Vehicle>>(vehicleService.getAllVehicle(),HttpStatus.OK);
    }

    @GetMapping("/details/{name}")
    public ResponseEntity<Vehicle> getVehicleDetails(@PathVariable("name") String name){
        return new ResponseEntity<Vehicle>(vehicleService.getVehicleDetails(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeVehicle(@PathVariable("id") Integer id){
        vehicleService.removeVehicle(id);
        String result = "Vehicle is deleted of id "+id;
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle){
        Vehicle v = vehicleService.updateVehicle(vehicle);
        return new ResponseEntity<Vehicle>(v,HttpStatus.OK);
    }

}
