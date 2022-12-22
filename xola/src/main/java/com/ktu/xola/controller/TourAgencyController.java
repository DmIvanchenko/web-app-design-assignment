package com.ktu.xola.controller;

import com.ktu.xola.model.Hotel;
import com.ktu.xola.model.TourAgency;
import com.ktu.xola.service.TourAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TourAgencyController {
    @Autowired
    private TourAgencyService tourAgencyService;

    @GetMapping("/touragencies")
    public ResponseEntity<List<TourAgency>> findAllTourAgencies(){
        return ResponseEntity.ok().body(tourAgencyService.findAllTourAgencies());
    }

    @GetMapping("/touragencies/{id}")
    public ResponseEntity<TourAgency> findTourAgencyById(@PathVariable int id){
        return ResponseEntity.ok().body(tourAgencyService.findTourAgencyById(id));
    }

    @PostMapping("/touragencies")
    public ResponseEntity<TourAgency> createTourAgency(@RequestBody TourAgency tourAgency){
        return ResponseEntity.ok().body(this.tourAgencyService.createTourAgency(tourAgency));

    }

    @PutMapping("/touragencies/{id}")
    public ResponseEntity<TourAgency> updateTourAgency(@PathVariable int id,@RequestBody TourAgency tourAgency ){
        tourAgency.setId(id);
        return ResponseEntity.ok().body(this.tourAgencyService.updateTourAgency(tourAgency));
    }

    @DeleteMapping("/touragencies/{id}")
    public ResponseEntity<?> deleteTourAgency(@PathVariable int id){
        this.tourAgencyService.deleteTourAgency(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
