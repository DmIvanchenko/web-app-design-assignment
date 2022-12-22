package com.ktu.xola.controller;

import com.ktu.xola.model.Room;
import com.ktu.xola.model.Tour;
import com.ktu.xola.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> findAllTours(){
        return ResponseEntity.ok().body(tourService.findAllTours());
    }

    @GetMapping("/tours/{id}")
    public ResponseEntity<Tour> findTourById(@PathVariable int id){
        return ResponseEntity.ok().body(tourService.findTourById(id));
    }

    @PostMapping("/tours")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour){
        return ResponseEntity.ok().body(this.tourService.createTour(tour));

    }

    @PutMapping("/tours/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable int id,@RequestBody Tour tour ){
        tour.setId(id);
        return ResponseEntity.ok().body(this.tourService.updateTour(tour));
    }

    @DeleteMapping("/tours/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable int id){
        this.tourService.deleteTour(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
