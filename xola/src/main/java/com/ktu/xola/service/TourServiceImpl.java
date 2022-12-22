package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.Room;
import com.ktu.xola.model.Tour;
import com.ktu.xola.repository.TourAgencyRepository;
import com.ktu.xola.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TourServiceImpl implements TourService{
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    TourAgencyRepository tourAgencyRepository;

    @Override
    public Tour createTour(Tour tour) {
        if (tourAgencyRepository.findById(tour.getTourAgency()).isPresent()) {
            return tourRepository.save(tour);
        }else {
            throw new ResourceNotFoundException("Record not found " + tour.getId());
        }
    }

    @Override
    public Tour updateTour(Tour tour) {
        Optional<Tour> tourDb = this.tourRepository.findById(tour.getId());
        if(tourDb.isPresent()){
            Tour updatedTour = tourDb.get();
            updatedTour.setId(tour.getId());
            updatedTour.setTourName(tour.getTourName());
            updatedTour.setTourAgency(tour.getTourAgency());
            updatedTour.setPrice(tour.getPrice());
            return updatedTour;
        }else {
            throw new ResourceNotFoundException("Record not found " + tour.getId());
        }
    }

    @Override
    public List<Tour> findAllTours() {
        return this.tourRepository.findAll();
    }

    @Override
    public Tour findTourById(int tourId) {
        Optional<Tour> tourDb = this.tourRepository.findById(tourId);
        if (tourDb.isPresent()){
            return tourDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + tourId);
        }
    }

    @Override
    public void deleteTour(int tourId) {
        Optional<Tour> tourDb = this.tourRepository.findById(tourId);
        if (tourDb.isPresent()){
            this.tourRepository.delete(tourDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + tourId);
        }
    }
}
