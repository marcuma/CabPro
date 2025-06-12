package com.simplilearn.cabproapi.service;

import com.simplilearn.cabproapi.model.Cab;

import java.util.List;

public interface CabService {
    Cab getCabById(int id);
    List<Cab> getAllCabs();
}
