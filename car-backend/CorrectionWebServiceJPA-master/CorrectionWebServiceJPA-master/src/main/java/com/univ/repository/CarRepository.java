package com.univ.repository;

import com.univ.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    Car findByPlateNumber(String plateNumber);
}
