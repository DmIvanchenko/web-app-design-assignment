package com.ktu.xola.repository;

import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.TourAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourAgencyRepository extends JpaRepository<TourAgency, Integer> {
}
