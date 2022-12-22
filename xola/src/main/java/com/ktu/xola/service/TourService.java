package com.ktu.xola.service;

import com.ktu.xola.model.Room;
import com.ktu.xola.model.Tour;

import java.util.List;

public interface TourService {
    Tour createTour(Tour tour);
    Tour updateTour(Tour tour);
    List<Tour> findAllTours();
    Tour findTourById(int tourId);
    void deleteTour(int tourId);
}
