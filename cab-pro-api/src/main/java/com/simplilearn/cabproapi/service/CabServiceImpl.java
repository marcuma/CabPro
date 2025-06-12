package com.simplilearn.cabproapi.service;

import com.simplilearn.cabproapi.model.Cab;
import com.simplilearn.cabproapi.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CabServiceImpl implements CabService {
    private final CabRepository cabRepository;

    @Autowired
    public CabServiceImpl(CabRepository cabRepository) {
        this.cabRepository = cabRepository;
    }

    @Override
    public Cab getCabById(int id) {
        return cabRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cab> getAllCabs() {
        return cabRepository.findAll();
    }
}
