package com.sda.springdemojavaee14.repository;

import com.sda.springdemojavaee14.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ReservationRepository {

    public List<Reservation> findAllReservationInRepository(){
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
