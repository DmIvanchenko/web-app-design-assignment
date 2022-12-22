package com.ktu.xola.controller;

import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.Hotel;
import com.ktu.xola.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> findAllHotels(){
        return ResponseEntity.ok().body(hotelService.findAllHotels());
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable int id){
        return ResponseEntity.ok().body(hotelService.findHotelById(id));
    }

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.ok().body(this.hotelService.createHotel(hotel));

    }

    @PutMapping("/hotels/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id,@RequestBody Hotel hotel ){
        hotel.setId(id);
        return ResponseEntity.ok().body(this.hotelService.updateHotel(hotel));
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable int id){
        this.hotelService.deleteHotel(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
