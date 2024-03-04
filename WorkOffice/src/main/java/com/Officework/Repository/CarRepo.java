package com.Officework.Repository;

import com.Officework.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CarRepo extends JpaRepository<Car, Long> {

//    @Query("SELECT c FROM Car c JOIN c.engineDetails ed WHERE ed.enginePower >= :enginePower AND ed.engineType = :engineType")
//    List<Car> findAllByEngineAndTransmission(String enginePower, String engineType);
@Query("SELECT c FROM Car c JOIN c.engineDetails ed WHERE ed.enginePower = :enginePower AND ed.engineType = :engineType AND c.tt = :tt")
List<Car> findAllByEngineAndTransmission(String enginePower, String engineType, String tt);

}

