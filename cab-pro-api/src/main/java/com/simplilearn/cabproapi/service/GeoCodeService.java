package com.simplilearn.cabproapi.service;

import com.simplilearn.cabproapi.model.GeoProperties;
import java.util.Optional;

public interface GeoCodeService {
    public Optional<GeoProperties> getGeoCode(String address);
}
