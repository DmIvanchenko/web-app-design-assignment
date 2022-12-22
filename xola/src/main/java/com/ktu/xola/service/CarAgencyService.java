package com.ktu.xola.service;



import com.ktu.xola.model.CarAgency;

import java.util.List;

public interface CarAgencyService {
    CarAgency createCarAgency(CarAgency carAgency);
    CarAgency updateCarAgency(CarAgency carAgency);
    List<CarAgency> findAllCarAgencies();
    CarAgency findCarAgencyById(int carAgencyId);
    void deleteCarAgency(int carAgencyId);
}
