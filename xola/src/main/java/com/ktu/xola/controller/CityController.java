package com.ktu.xola.controller;

import com.ktu.xola.model.City;
import com.ktu.xola.model.User;
import com.ktu.xola.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> findAllCities(){
        return ResponseEntity.ok().body(cityService.findAllCities());
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> findCityById(@PathVariable int id){
        City city = cityService.findCityById(id);
        if(city != null){
            return ResponseEntity.ok().body(city);
        }else {
            return new ResponseEntity<>(city, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/cities")
    public ResponseEntity<City> createCity(@RequestBody City city){
        return ResponseEntity.ok().body(this.cityService.createCity(city));

    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable int id,@RequestBody City city ){
        city.setId(id);
        return ResponseEntity.ok().body(this.cityService.updateCity(city));

    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable int id){
        this.cityService.deleteCity(id);
        ResponseEntity.ok();
    }
}
