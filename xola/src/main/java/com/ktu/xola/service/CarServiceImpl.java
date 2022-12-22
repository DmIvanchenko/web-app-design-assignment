package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.Car;
import com.ktu.xola.model.TourAgency;
import com.ktu.xola.repository.CarAgencyRepository;
import com.ktu.xola.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarAgencyRepository carAgencyRepository;

    @Override
    public Car createCar(Car car) {
        if (carAgencyRepository.findById(car.getCarAgency()).isPresent()) {
            return carRepository.save(car);
        }else {
            throw new ResourceNotFoundException("Record not found " + car.getId());
        }
    }

    @Override
    public Car updateCar(Car car) {
        Optional<Car> caryDb = this.carRepository.findById(car.getId());
        if(caryDb.isPresent()){
            Car updatedCar = caryDb.get();
            updatedCar.setId(car.getId());
            updatedCar.setPrice(car.getPrice());
            updatedCar.setCarModel(car.getCarModel());
            updatedCar.setCarAgency(car.getCarAgency());
            return updatedCar;
        }else {
            throw new ResourceNotFoundException("Record not found " + car.getId());
        }
    }

    @Override
    public List<Car> findAllCars() {
        return this.carRepository.findAll();
    }

    @Override
    public Car findCarById(int carId) {
        Optional<Car> carDb = this.carRepository.findById(carId);
        if (carDb.isPresent()){
            return carDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + carId);
        }
    }

    @Override
    public void deleteCar(int carId) {
        Optional<Car> carDb = this.carRepository.findById(carId);
        if (carDb.isPresent()){
            this.carRepository.delete(carDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + carId);
        }
    }
}
