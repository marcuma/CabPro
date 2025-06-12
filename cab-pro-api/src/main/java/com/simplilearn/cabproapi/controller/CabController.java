package com.simplilearn.cabproapi.controller;

import com.simplilearn.cabproapi.model.Cab;
import com.simplilearn.cabproapi.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
@CrossOrigin
public class CabController {

    private final CabService cabService;

    @Autowired
    public CabController(CabService cabService) {
        this.cabService = cabService;
    }

    @GetMapping("/cabs/{id}")
    public Cab getCabById(@PathVariable("id") int id) {
        return cabService.getCabById(id);
    }

    @GetMapping("/cabs")
    public List<Cab> getAllCabs() {
        return this.cabService.getAllCabs();
    }
}
