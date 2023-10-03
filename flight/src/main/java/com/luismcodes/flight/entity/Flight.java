package com.luismcodes.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    @SequenceGenerator(
            name = "id_flight_sequence",
            sequenceName = "id_flight_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_flight_sequence"
    )
    private Integer id_flight;
    private String airline;
    private String origin;
    private String destination;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private Double price;
}
