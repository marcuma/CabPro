package com.simplilearn.cabproapi.service;

import com.simplilearn.cabproapi.model.Trip;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public interface TripService {
    public Trip getTrip(String fromAddress, String toAddress, int cabId) throws UnsupportedEncodingException, URISyntaxException;
}
