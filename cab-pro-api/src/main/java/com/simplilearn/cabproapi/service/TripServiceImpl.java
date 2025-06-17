package com.simplilearn.cabproapi.service;

import com.google.gson.GsonBuilder;
import com.simplilearn.cabproapi.model.GeoProperties;
import com.simplilearn.cabproapi.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {

    private final GeoCodeService geoCodeService;
    private final CabService  cabService;

    @Autowired
    public TripServiceImpl(GeoCodeService geoCodeService, CabService cabService) {
        this.geoCodeService = geoCodeService;
        this.cabService = cabService;
    }

    @Override
    public Trip getTrip(String fromAddress, String toAddress, int cabId) {
        Trip trip = new Trip();
        trip.setFrom(fromAddress);
        trip.setTo(toAddress);
        Optional<GeoProperties> source = geoCodeService.getGeoCode(fromAddress);
        Optional<GeoProperties> destination = geoCodeService.getGeoCode(toAddress);
        if (source.isPresent() && destination.isPresent()) {
            GeoProperties fromProps = source.get();
            GeoProperties toProps = destination.get();
            trip.setFromLongitude(fromProps.getLon());
            trip.setFromLatitude(fromProps.getLat());
            trip.setToLongitude(toProps.getLon());
            trip.setToLatitude(toProps.getLat());
        }
        double rate = cabService.getCabById(cabId).getRate();
        trip.setCabRate(String.format("$%.2f", rate));
        getDistance(trip);
        trip.setRate(String.format("$%.2f", rate * Double.parseDouble(trip.getDistance())));

        return trip;
    }

    private void getDistance(Trip trip) {
        double lat1 =  trip.getFromLatitude();
        double lat2 = trip.getToLatitude();
        double lon1 = trip.getFromLongitude();
        double lon2 = trip.getToLongitude();

        double earthRadius = 3958.8; // in miles
        double dLat = deg2rad(lat2 - lat1);
        double dLon = deg2rad(lon2 - lon1);

        double centralAngle =
                Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.sin(dLon/2) * Math.sin(dLon/2);
        double angularDistance = 2 * Math.atan2(Math.sqrt(centralAngle), Math.sqrt(1-centralAngle));
        double distance = earthRadius * angularDistance;
        trip.setDistance(String.format("%.2f", distance));

    }

    private double deg2rad(double deg) {
        return deg * Math.PI / 180;
    }
}
