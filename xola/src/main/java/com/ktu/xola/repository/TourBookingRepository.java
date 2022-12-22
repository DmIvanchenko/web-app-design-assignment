package com.ktu.xola.repository;

import com.ktu.xola.model.HotelBooking;
import com.ktu.xola.model.TourBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourBookingRepository extends JpaRepository<TourBooking, Integer> {
}
