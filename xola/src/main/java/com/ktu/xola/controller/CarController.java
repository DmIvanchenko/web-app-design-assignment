package com.ktu.xola.controller;

import com.ktu.xola.model.Car;
import com.ktu.xola.model.Hotel;
import com.ktu.xola.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> findAllCars(){
        return ResponseEntity.ok().body(carService.findAllCars());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable int id){
        return ResponseEntity.ok().body(carService.findCarById(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        return ResponseEntity.ok().body(this.carService.createCar(car));

    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id,@RequestBody Car car ){
        car.setId(id);
        return ResponseEntity.ok().body(this.carService.updateCar(car));
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable int id){
        this.carService.deleteCar(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
