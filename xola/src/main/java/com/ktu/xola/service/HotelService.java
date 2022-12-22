package com.ktu.xola.service;

import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    List<Hotel> findAllHotels();
    Hotel findHotelById(int hotelId);
    void deleteHotel(int hotelId);
}
