package com.ktu.xola.controller;

import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.CarBooking;
import com.ktu.xola.service.CarBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarBookingController {
    @Autowired
    private CarBookingService carBookingService;

    @GetMapping("/carbookings")
    public ResponseEntity<List<CarBooking>> findAllCarBookings(){
        return ResponseEntity.ok().body(carBookingService.findAllCarBookings());
    }

    @GetMapping("/carbookings/{id}")
    public ResponseEntity<CarBooking> findCarBookingById(@PathVariable int id){
        return ResponseEntity.ok().body(carBookingService.findCarBookingById(id));
    }

    @PostMapping("/carbookings")
    public ResponseEntity<CarBooking> createCarBooking(@RequestBody CarBooking carBooking){
        return ResponseEntity.ok().body(this.carBookingService.createCarBooking(carBooking));

    }

    @PutMapping("/carbookings/{id}")
    public ResponseEntity<CarBooking> updateCarBooking(@PathVariable int id,@RequestBody CarBooking carBooking ){
        carBooking.setId(id);
        return ResponseEntity.ok().body(this.carBookingService.updateCarBooking(carBooking));

    }

    @DeleteMapping("/carbookings/{id}")
    public ResponseEntity<?> deleteCarBooking(@PathVariable int id){
        this.carBookingService.deleteCarBooking(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
