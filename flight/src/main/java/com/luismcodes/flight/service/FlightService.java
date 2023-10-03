package com.luismcodes.flight.service;

import com.luismcodes.flight.entity.Flight;
import com.luismcodes.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Iterable<Flight> getFlights() {
        Iterable<Flight> flights = null;
        flights = flightRepository.findAll();
        return flights;
    }
}
