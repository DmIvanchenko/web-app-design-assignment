package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.City;
import com.ktu.xola.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(City city) {
        Optional<City> cityDb = this.cityRepository.findById(city.getId());
        if(cityDb.isPresent()){
            City updatedCity = cityDb.get();
            updatedCity.setId(city.getId());
            updatedCity.setName(city.getName());
            cityRepository.save(updatedCity);
            return updatedCity;
        }else {
            throw new ResourceNotFoundException("Record not found " + city.getId());
        }

    }

    @Override
    public List<City> findAllCities() {
        return this.cityRepository.findAll();
    }

    @Override
    public City findCityById(int cityId) {
        Optional<City> cityDb = this.cityRepository.findById(cityId);
        if (cityDb.isPresent()){
            return cityDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + cityId);
        }
    }

    @Override
    public void deleteCity(int cityId) {
        Optional<City> cityDb = this.cityRepository.findById(cityId);
        if (!cityDb.isPresent()){
            throw new ResourceNotFoundException("Record not found " + cityId);
        }else {
            this.cityRepository.delete(cityDb.get());
        }
    }
}
