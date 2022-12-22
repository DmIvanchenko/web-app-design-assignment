package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.Hotel;
import com.ktu.xola.model.TourAgency;
import com.ktu.xola.repository.CityRepository;
import com.ktu.xola.repository.TourAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TourAgencyServiceImpl implements TourAgencyService{
    @Autowired
    private TourAgencyRepository tourAgencyRepository;
    @Autowired
    private CityRepository cityRepository;
    @Override
    public TourAgency createTourAgency(TourAgency tourAgency) {
        if (cityRepository.findById(tourAgency.getCity()).isPresent()) {
            return tourAgencyRepository.save(tourAgency);
        }else {
            throw new ResourceNotFoundException("Record not found " + tourAgency.getId());
        }
    }

    @Override
    public TourAgency updateTourAgency(TourAgency tourAgency) {
        Optional<TourAgency> touAgencyDb = this.tourAgencyRepository.findById(tourAgency.getId());
        if(touAgencyDb.isPresent()){
            TourAgency updatedTourAgency = touAgencyDb.get();
            updatedTourAgency.setId(tourAgency.getId());
            updatedTourAgency.setName(tourAgency.getName());
            updatedTourAgency.setCity(tourAgency.getCity());
            return updatedTourAgency;
        }else {
            throw new ResourceNotFoundException("Record not found " + tourAgency.getId());
        }
    }

    @Override
    public List<TourAgency> findAllTourAgencies() {
        return this.tourAgencyRepository.findAll();
    }

    @Override
    public TourAgency findTourAgencyById(int tourAgencyId) {
        Optional<TourAgency> tourAgencyDb = this.tourAgencyRepository.findById(tourAgencyId);
        if (tourAgencyDb.isPresent()){
            return tourAgencyDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + tourAgencyId);
        }    }

    @Override
    public void deleteTourAgency(int tourAgencyId) {
        Optional<TourAgency> tourAgencyDb = this.tourAgencyRepository.findById(tourAgencyId);
        if (tourAgencyDb.isPresent()){
            this.tourAgencyRepository.delete(tourAgencyDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + tourAgencyId);
        }
    }
}
