package com.ktu.xola.service;

import com.ktu.xola.model.City;
import com.ktu.xola.model.User;
import org.springframework.web.client.ResourceAccessException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CityService {
    City createCity(City city);
    City updateCity(City city);
    List<City> findAllCities();
    City findCityById(int cityId) throws EntityNotFoundException;
    void deleteCity(int cityId) throws ResourceAccessException;
}
