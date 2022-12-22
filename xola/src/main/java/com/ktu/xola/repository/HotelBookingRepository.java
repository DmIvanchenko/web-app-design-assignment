package com.ktu.xola.repository;

import com.ktu.xola.model.CarBooking;
import com.ktu.xola.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Integer> {
}
