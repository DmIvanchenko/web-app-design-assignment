package com.ktu.xola.service;

import com.ktu.xola.model.Hotel;
import com.ktu.xola.model.TourAgency;

import java.util.List;

public interface TourAgencyService {
    TourAgency createTourAgency(TourAgency tourAgency);
    TourAgency updateTourAgency(TourAgency tourAgency);
    List<TourAgency> findAllTourAgencies();
    TourAgency findTourAgencyById(int tourAgencyId);
    void deleteTourAgency(int tourAgencyId);
}
