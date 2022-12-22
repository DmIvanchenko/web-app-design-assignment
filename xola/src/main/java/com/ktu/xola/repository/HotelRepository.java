package com.ktu.xola.repository;

import com.ktu.xola.model.CarAgency;
import com.ktu.xola.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
