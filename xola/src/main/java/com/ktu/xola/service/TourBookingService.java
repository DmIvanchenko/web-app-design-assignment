package com.ktu.xola.service;

import com.ktu.xola.model.HotelBooking;
import com.ktu.xola.model.TourBooking;

import java.util.List;

public interface TourBookingService {
    TourBooking createTourBooking(TourBooking tourBooking);
    TourBooking updateTourBooking(TourBooking tourBooking);
    List<TourBooking> findAllTourBookings();
    TourBooking findTourBookingById(int tourBookingId);
    void deleteTourBooking(int tourBookingId);
}
