package com.ktu.xola.repository;

import com.ktu.xola.model.Room;
import com.ktu.xola.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Integer> {
}
