package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.CarBooking;
import com.ktu.xola.model.HotelBooking;
import com.ktu.xola.repository.HotelBookingRepository;
import com.ktu.xola.repository.RoomRepository;
import com.ktu.xola.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelBookingServiceImpl implements HotelBookingService{
    @Autowired
    private HotelBookingRepository hotelBookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public HotelBooking createHotelBooking(HotelBooking hotelBooking) {
        if (roomRepository.findById(hotelBooking.getRoom()).isPresent()&&userRepository.findById(hotelBooking.getUser()).isPresent()) {
            return hotelBookingRepository.save(hotelBooking);
        }else {
            throw new ResourceNotFoundException("Record not found " + hotelBooking.getId());
        }
    }

    @Override
    public HotelBooking updateHotelBooking(HotelBooking hotelBooking) {
        Optional<HotelBooking> hotelBookingDb = this.hotelBookingRepository.findById(hotelBooking.getId());
        if(hotelBookingDb.isPresent()){
            HotelBooking updatedHotelBooking = hotelBookingDb.get();
            updatedHotelBooking.setId(hotelBooking.getId());
            updatedHotelBooking.setRoom(hotelBooking.getRoom());
            updatedHotelBooking.setUser(hotelBooking.getUser());
            updatedHotelBooking.setCheckIn(hotelBooking.getCheckIn());
            updatedHotelBooking.setCheckOut(hotelBooking.getCheckOut());
            return updatedHotelBooking;
        }else {
            throw new ResourceNotFoundException("Record not found " + hotelBooking.getId());
        }
    }

    @Override
    public List<HotelBooking> findAllHotelBookings() {
        return this.hotelBookingRepository.findAll();
    }

    @Override
    public HotelBooking findHotelBookingById(int hotelBookingId) {
        Optional<HotelBooking> hotelBookingDb = this.hotelBookingRepository.findById(hotelBookingId);
        if (hotelBookingDb.isPresent()){
            return hotelBookingDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + hotelBookingId);
        }
    }

    @Override
    public void deleteHotelBooking(int hotelBookingId) {
        Optional<HotelBooking> hotelBookingDb = this.hotelBookingRepository.findById(hotelBookingId);
        if (hotelBookingDb.isPresent()){
            this.hotelBookingRepository.delete(hotelBookingDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + hotelBookingId);
        }
    }
}
