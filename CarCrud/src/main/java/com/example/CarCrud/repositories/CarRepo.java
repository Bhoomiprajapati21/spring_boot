package com.example.CarCrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarCrud.models.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

}
