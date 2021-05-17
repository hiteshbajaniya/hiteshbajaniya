package com.neosoft.vehicle.controller;

import com.neosoft.vehicle.entity.Vehicle;
import com.neosoft.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
    public ResponseEntity<CompletableFuture<List<Vehicle>>> getVehicleByType(@PathVariable("fuelType") String fuelType){

        CompletableFuture<List<Vehicle>> category = vehicleService.getVehicleByType(fuelType);
        return new ResponseEntity<CompletableFuture<List<Vehicle>>>(category,HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<CompletableFuture<List<Vehicle>>> getVehicleByBrand(@PathVariable("brand") String brand){
        CompletableFuture<List<Vehicle>> data = vehicleService.getVehicleByBrand(brand);
        return new ResponseEntity<CompletableFuture<List<Vehicle>>>(data, HttpStatus.OK);
    }

    @GetMapping("/all")
    public CompletableFuture<List<Vehicle>> getAllVehicle(){
      return vehicleService.getAllVehicle();
       // return new ResponseEntity<CompletableFuture<List<Vehicle>>>(data,HttpStatus.OK);
    }

    @GetMapping("/details/{name}")
    public ResponseEntity<CompletableFuture<Vehicle>> getVehicleDetails(@PathVariable("name") String name){
        CompletableFuture<Vehicle> vehicleDetails = vehicleService.getVehicleDetails(name);
        return new ResponseEntity<CompletableFuture<Vehicle>>(vehicleDetails, HttpStatus.OK);
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
