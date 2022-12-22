package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.Hotel;
import com.ktu.xola.repository.CityRepository;
import com.ktu.xola.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        if (cityRepository.findById(hotel.getCity()).isPresent()) {
            return hotelRepository.save(hotel);
        }else {
            throw new ResourceNotFoundException("Record not found " + hotel.getCity());
        }
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        Optional<Hotel> hotelDb = this.hotelRepository.findById(hotel.getId());
        if(hotelDb.isPresent()){
            Hotel updatedHotel = hotelDb.get();
            updatedHotel.setId(hotel.getId());
            updatedHotel.setName(hotel.getName());
            updatedHotel.setCity(hotel.getCity());
            return updatedHotel;
        }else {
            throw new ResourceNotFoundException("Record not found " + hotel.getId());
        }
    }

    @Override
    public List<Hotel> findAllHotels() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel findHotelById(int hotelId) {
        Optional<Hotel> hotelDb = this.hotelRepository.findById(hotelId);
        if (hotelDb.isPresent()){
            return hotelDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + hotelId);
        }
    }

    @Override
    public void deleteHotel(int hotelId) {
        Optional<Hotel> hotelDb = this.hotelRepository.findById(hotelId);
        if (hotelDb.isPresent()){
            this.hotelRepository.delete(hotelDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + hotelId);
        }
    }
}
