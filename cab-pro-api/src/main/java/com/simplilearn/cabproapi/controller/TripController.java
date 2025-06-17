package com.simplilearn.cabproapi.controller;

import com.simplilearn.cabproapi.model.Cab;
import com.simplilearn.cabproapi.model.GeoCode;
import com.simplilearn.cabproapi.model.Trip;
import com.simplilearn.cabproapi.service.CabService;
import com.simplilearn.cabproapi.service.GeoCodeService;
import com.simplilearn.cabproapi.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trip/{cabId}")
    public ResponseEntity<Trip> getTrip(
            @PathVariable("cabId") int cabId,
            @RequestParam String fromAddress,
            @RequestParam String toAddress) throws UnsupportedEncodingException, URISyntaxException {

        Trip trip = tripService.getTrip(fromAddress, toAddress, cabId);
        return ResponseEntity.ok(trip);
    }

}
