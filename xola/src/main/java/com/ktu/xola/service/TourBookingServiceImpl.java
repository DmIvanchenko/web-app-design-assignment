package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.HotelBooking;
import com.ktu.xola.model.TourBooking;
import com.ktu.xola.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class TourBookingServiceImpl implements TourBookingService{
    @Autowired
    private TourBookingRepository tourBookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TourRepository tourRepository;

    @Override
    public TourBooking createTourBooking(TourBooking tourBooking) {
        if (tourRepository.findById(tourBooking.getTour()).isPresent()&&userRepository.findById(tourBooking.getUser()).isPresent()) {
            return tourBookingRepository.save(tourBooking);
        }else {
            throw new ResourceNotFoundException("Record not found " + tourBooking.getId());
        }
    }

    @Override
    public TourBooking updateTourBooking(TourBooking tourBooking) {
        Optional<TourBooking> tourBookingDb = this.tourBookingRepository.findById(tourBooking.getId());
        if(tourBookingDb.isPresent()){
            TourBooking updatedTourBooking = tourBookingDb.get();
            updatedTourBooking.setId(tourBooking.getId());
            updatedTourBooking.setTour(tourBooking.getTour());
            updatedTourBooking.setUser(tourBooking.getUser());
            updatedTourBooking.setCheckIn(tourBooking.getCheckIn());
            updatedTourBooking.setCheckOut(tourBooking.getCheckOut());
            return updatedTourBooking;
        }else {
            throw new ResourceNotFoundException("Record not found " + tourBooking.getId());
        }
    }

    @Override
    public List<TourBooking> findAllTourBookings() {
        return this.tourBookingRepository.findAll();
    }

    @Override
    public TourBooking findTourBookingById(int tourBookingId) {
        Optional<TourBooking> tourBookingDb = this.tourBookingRepository.findById(tourBookingId);
        if (tourBookingDb.isPresent()){
            return tourBookingDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + tourBookingId);
        }
    }

    @Override
    public void deleteTourBooking(int tourBookingId) {
        Optional<TourBooking> tourBookingDb = this.tourBookingRepository.findById(tourBookingId);
        if (tourBookingDb.isPresent()){
            this.tourBookingRepository.delete(tourBookingDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + tourBookingId);
        }
    }
}
