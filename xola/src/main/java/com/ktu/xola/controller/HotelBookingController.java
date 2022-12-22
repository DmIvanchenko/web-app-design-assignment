package com.ktu.xola.controller;

import com.ktu.xola.model.CarBooking;
import com.ktu.xola.model.HotelBooking;
import com.ktu.xola.service.CarBookingService;
import com.ktu.xola.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelBookingController {
    @Autowired
    private HotelBookingService hotelBookingService;

    @GetMapping("/hotelbookings")
    public ResponseEntity<List<HotelBooking>> findAllHotelBookings(){
        return ResponseEntity.ok().body(hotelBookingService.findAllHotelBookings());
    }

    @GetMapping("/hotelbookings/{id}")
    public ResponseEntity<HotelBooking> findHotelBookingById(@PathVariable int id){
        return ResponseEntity.ok().body(hotelBookingService.findHotelBookingById(id));
    }

    @PostMapping("/hotelbookings")
    public ResponseEntity<HotelBooking> createHotelBooking(@RequestBody HotelBooking hotelBooking){
        return ResponseEntity.ok().body(this.hotelBookingService.createHotelBooking(hotelBooking));

    }

    @PutMapping("/hotelbookings/{id}")
    public ResponseEntity<HotelBooking> updateHotelBooking(@PathVariable int id,@RequestBody HotelBooking hotelBooking ){
        hotelBooking.setId(id);
        return ResponseEntity.ok().body(this.hotelBookingService.updateHotelBooking(hotelBooking));

    }

    @DeleteMapping("/hotelbookings/{id}")
    public ResponseEntity<?> deleteHotelBooking(@PathVariable int id){
        this.hotelBookingService.deleteHotelBooking(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
