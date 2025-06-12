package com.simplilearn.cabproapi.controller;
import com.simplilearn.cabproapi.model.Cab;
import com.simplilearn.cabproapi.service.CabService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CabTest {

    @Autowired
    private CabService cabService;

    @Test
    public void testGetCabById() {
        Cab cab = cabService.getCabById(1);
        assertEquals(cab.getId(), 1);
    }
}
