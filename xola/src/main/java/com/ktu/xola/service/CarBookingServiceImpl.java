package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.CarBooking;
import com.ktu.xola.repository.CarBookingRepository;
import com.ktu.xola.repository.CarRepository;
import com.ktu.xola.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarBookingServiceImpl implements CarBookingService{
    @Autowired
    private CarBookingRepository carBookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;


    @Override
    public CarBooking createCarBooking(CarBooking carBooking) {
        if (carRepository.findById(carBooking.getCar()).isPresent()&&userRepository.findById(carBooking.getUser()).isPresent()) {
            return carBookingRepository.save(carBooking);
        }else {
            throw new ResourceNotFoundException("Record not found " + carBooking.getId());
        }

    }

    @Override
    public CarBooking updateCarBooking(CarBooking carBooking) {
        Optional<CarBooking> carBookingDb = this.carBookingRepository.findById(carBooking.getId());
        if(carBookingDb.isPresent()){
            CarBooking updatedCarBooking = carBookingDb.get();
            updatedCarBooking.setId(carBooking.getId());
            updatedCarBooking.setCar(carBooking.getCar());
            updatedCarBooking.setUser(carBooking.getUser());
            updatedCarBooking.setCheckIn(carBooking.getCheckIn());
            updatedCarBooking.setCheckOut(carBooking.getCheckOut());
            return updatedCarBooking;
        }else {
            throw new ResourceNotFoundException("Record not found " + carBooking.getId());
        }
    }

    @Override
    public List<CarBooking> findAllCarBookings() {
        return this.carBookingRepository.findAll();
    }

    @Override
    public CarBooking findCarBookingById(int carBookingId) {
        Optional<CarBooking> carBookingDb = this.carBookingRepository.findById(carBookingId);
        if (carBookingDb.isPresent()){
            return carBookingDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + carBookingId);
        }
    }

    @Override
    public void deleteCarBooking(int carBookingId) {
        Optional<CarBooking> carBookingDb = this.carBookingRepository.findById(carBookingId);
        if (carBookingDb.isPresent()){
            this.carBookingRepository.delete(carBookingDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + carBookingId);
        }
    }
}
