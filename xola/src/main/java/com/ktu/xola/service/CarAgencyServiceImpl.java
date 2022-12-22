package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.City;
import com.ktu.xola.repository.CarAgencyRepository;
import com.ktu.xola.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarAgencyServiceImpl implements CarAgencyService{
    @Autowired
    private CarAgencyRepository carAgencyRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public CarAgency createCarAgency(CarAgency carAgency) {

        if (cityRepository.findById(carAgency.getCity()).isPresent()) {
            return carAgencyRepository.save(carAgency);
        }else {
            throw new ResourceNotFoundException("Record not found " + carAgency.getId());
        }

    }

    @Override
    public CarAgency updateCarAgency(CarAgency carAgency) {
        Optional<CarAgency> carAgencyDb = this.carAgencyRepository.findById(carAgency.getId());
        if(carAgencyDb.isPresent()){
            CarAgency updatedCarAgency = carAgencyDb.get();
            updatedCarAgency.setId(carAgency.getId());
            updatedCarAgency.setName(carAgency.getName());
            updatedCarAgency.setCity(carAgency.getCity());
            return updatedCarAgency;
        }else {
            throw new ResourceNotFoundException("Record not found " + carAgency.getId());
        }
    }

    @Override
    public List<CarAgency> findAllCarAgencies() {
        return this.carAgencyRepository.findAll();
    }

    @Override
    public CarAgency findCarAgencyById(int carAgencyId) {
        Optional<CarAgency> carAgencyDb = this.carAgencyRepository.findById(carAgencyId);
        if (carAgencyDb.isPresent()){
            return carAgencyDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + carAgencyId);
        }
    }

    @Override
    public void deleteCarAgency(int carAgencyId) {
        Optional<CarAgency> carAgencyDb = this.carAgencyRepository.findById(carAgencyId);
        if (carAgencyDb.isPresent()){
            this.carAgencyRepository.delete(carAgencyDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + carAgencyId);
        }
    }
}
