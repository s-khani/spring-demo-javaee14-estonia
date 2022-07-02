package com.sda.springdemojavaee14.controller.rest;


import com.sda.springdemojavaee14.entity.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ReservationRestController {


    @GetMapping("/reservations")
    public List<Reservation> getAllReservation(){

        log.info("getting all Reservations");
        return List.of(
                new Reservation(1L, 12L, LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                        "Wołek", "51124", "m@op.pl", 10, ""),

                Reservation.builder()
                        .id(1L)
                        .tableNumber(12L)
                        .startBookingTime(LocalDateTime.now())
                        .endBookingTime(LocalDateTime.now().plusHours(2))
                        .surname("Samaneh")
                        .phoneNumber("555 555")
                        .email("s.khanimirzaee@gmail.com")
                        .numberOfPeople(5)
                        .address("address 5")
                        .build()
        );

    }
}
