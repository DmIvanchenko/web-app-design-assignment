package com.ktu.xola.service;

import com.ktu.xola.model.Car;
import com.ktu.xola.model.CarBooking;

import java.util.List;

public interface CarBookingService {
    CarBooking createCarBooking(CarBooking carBooking);
    CarBooking updateCarBooking(CarBooking carBooking);
    List<CarBooking> findAllCarBookings();
    CarBooking findCarBookingById(int carBookingId);
    void deleteCarBooking(int carBookingId);
}
