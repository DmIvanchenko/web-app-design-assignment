package com.ktu.xola.controller;

import com.ktu.xola.model.HotelBooking;
import com.ktu.xola.model.TourBooking;
import com.ktu.xola.service.HotelBookingService;
import com.ktu.xola.service.TourBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourBookingController {
    @Autowired
    private TourBookingService tourBookingService;

    @GetMapping("/tourbookings")
    public ResponseEntity<List<TourBooking>> findAllTourBookings(){
        return ResponseEntity.ok().body(tourBookingService.findAllTourBookings());
    }

    @GetMapping("/tourbookings/{id}")
    public ResponseEntity<TourBooking> findTourBookingById(@PathVariable int id){
        return ResponseEntity.ok().body(tourBookingService.findTourBookingById(id));
    }

    @PostMapping("/tourbookings")
    public ResponseEntity<TourBooking> createTourBooking(@RequestBody TourBooking tourBooking){
        return ResponseEntity.ok().body(this.tourBookingService.createTourBooking(tourBooking));

    }

    @PutMapping("/tourbookings/{id}")
    public ResponseEntity<TourBooking> updateTourBooking(@PathVariable int id,@RequestBody TourBooking tourBooking ){
        tourBooking.setId(id);
        return ResponseEntity.ok().body(this.tourBookingService.updateTourBooking(tourBooking));

    }

    @DeleteMapping("/tourbookings/{id}")
    public ResponseEntity<?> deleteTourBooking(@PathVariable int id){
        this.tourBookingService.deleteTourBooking(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
