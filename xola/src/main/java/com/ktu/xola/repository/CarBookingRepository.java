package com.ktu.xola.repository;

import com.ktu.xola.model.CarBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBookingRepository extends JpaRepository<CarBooking, Integer> {
}
