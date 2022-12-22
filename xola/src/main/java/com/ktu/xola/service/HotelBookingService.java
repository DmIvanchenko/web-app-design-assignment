package com.ktu.xola.service;

import com.ktu.xola.model.CarBooking;
import com.ktu.xola.model.HotelBooking;

import java.util.List;

public interface HotelBookingService {
    HotelBooking createHotelBooking(HotelBooking hotelBooking);
    HotelBooking updateHotelBooking(HotelBooking hotelBooking);
    List<HotelBooking> findAllHotelBookings();
    HotelBooking findHotelBookingById(int hotelBookingId);
    void deleteHotelBooking(int hotelBookingId);
}
