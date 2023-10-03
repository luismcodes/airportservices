package com.luismcodes.flight.repository;

import com.luismcodes.flight.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {
}
