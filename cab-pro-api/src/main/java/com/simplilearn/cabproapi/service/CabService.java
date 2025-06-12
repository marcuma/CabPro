package com.simplilearn.cabproapi.service;

import com.simplilearn.cabproapi.model.Cab;

import java.util.List;

public interface CabService {
    public Cab getCabById(int id);
    public List<Cab> getAllCabs();
}
