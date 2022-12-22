package com.ktu.xola.service;

import com.ktu.xola.model.Car;
import com.ktu.xola.model.City;

import java.util.List;

public interface CarService {
    Car createCar(Car car);
    Car updateCar(Car car);
    List<Car> findAllCars();
    Car findCarById(int carId);
    void deleteCar(int carId);
}
