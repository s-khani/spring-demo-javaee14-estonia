package com.sda.springdemojavaee14.controller.rest;


import com.sda.springdemojavaee14.dto.GenericError;
import com.sda.springdemojavaee14.entity.Reservation;
import com.sda.springdemojavaee14.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ReservationRestController {

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("/reservations")
    public List<Reservation> getAllReservation() {

        log.info("getting all Reservations");
        //not handle exeption will cuase 500
        /*if (true){
            throw new NullPointerException("Breaking the server");
        }*/
        return reservationService.findAllReservation();

    }

    @GetMapping("/reservations/{id}")
    // /reservations/1234
    // /reservations/998
    // @PathVariable("id") get id value from url and use for reservationId
    // 200 if there's result and response : ResponseEntity<reservation>
    // and 404 if wrong url was used by client and response : ResponseEntity<GenericError>

    public ResponseEntity<?> getReservationById(@PathVariable("id") Long reservationId) {

        log.info("trying to find reservation by id: [{}]", reservationId);

        var responseBody = reservationService.findReservationById(reservationId);
        //44 to 50 are the same
        // return ResponseEntity.status(HttpStatus.OK)
        //        .body(responseBody);
        // return ResponseEntity.status(200)
        //        .body(responseBody);

        ResponseEntity<Reservation> result = ResponseEntity.notFound().build();
        if (responseBody != null) {
            return ResponseEntity.ok(responseBody);
        } else {
            // https://danielmiessler.com/images/url-urn-uri-structure-2022.png
            String path = "/api/reservations/" + reservationId;
            try {
                //TODO: fix server URL
                URI uri = new URI("/api/reservations/" + reservationId);
                path = uri.getPath();
            } catch (URISyntaxException e) {
                log.warn("problems with creating URI", e);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    GenericError.builder()
                            .responseCode(404)
                            .timestamp(LocalDateTime.now())
                            .errorMessage("You provided wrong id: " + reservationId)
                            .path(path)
                            .build()
            );
        }
    }
}