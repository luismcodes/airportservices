package com.luismcodes.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {

    @Id
    @SequenceGenerator(
            name = "id_booking_sequence",
            sequenceName = "id_booking_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_booking_sequence"
    )
    private Integer id_booking;
    private Integer id_flight;
    private String passenger_name;
    private String seat;
    private String status;
    private String payment_method;
    private String phone_number;
}
