package com.luismcodes.booking.service;

import com.luismcodes.booking.entity.Booking;
import com.luismcodes.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Booking registerBooking(Booking bookingRequest) {
        String message = String.format("Hi %s, welcome to your flight. Your seat is: %s", bookingRequest.getPassenger_name(), bookingRequest.getSeat());

        bookingRepository.save(bookingRequest);

        kafkaTemplate.send(topicName, message);
        return bookingRequest;
    }
}
