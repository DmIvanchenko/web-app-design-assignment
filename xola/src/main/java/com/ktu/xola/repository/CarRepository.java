package com.ktu.xola.repository;

import com.ktu.xola.model.Car;
import com.ktu.xola.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
