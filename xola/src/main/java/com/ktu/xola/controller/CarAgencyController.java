package com.ktu.xola.controller;

import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.City;
import com.ktu.xola.service.CarAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarAgencyController {
    @Autowired
    private CarAgencyService carAgencyService;

    @GetMapping("/caragencies")
    public ResponseEntity<List<CarAgency>> findAllCarAgencies(){
        return ResponseEntity.ok().body(carAgencyService.findAllCarAgencies());
    }

    @GetMapping("/caragencies/{id}")
    public ResponseEntity<CarAgency> findCarAgencyById(@PathVariable int id){
        return ResponseEntity.ok().body(carAgencyService.findCarAgencyById(id));
    }

    @PostMapping("/caragencies")
    public ResponseEntity<CarAgency> createCarAgency(@RequestBody CarAgency carAgency){
        return ResponseEntity.ok().body(this.carAgencyService.createCarAgency(carAgency));

    }

    @PutMapping("/caragencies/{id}")
    public ResponseEntity<CarAgency> updateCarAgency(@PathVariable int id,@RequestBody CarAgency carAgency ){
        carAgency.setId(id);
        return ResponseEntity.ok().body(this.carAgencyService.updateCarAgency(carAgency));

    }

    @DeleteMapping("/caragencies/{id}")
    public ResponseEntity<?> deleteCarAgency(@PathVariable int id){
        this.carAgencyService.deleteCarAgency(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
