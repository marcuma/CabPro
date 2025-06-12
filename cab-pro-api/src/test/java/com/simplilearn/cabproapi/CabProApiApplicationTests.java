package com.simplilearn.cabproapi;

import com.simplilearn.cabproapi.controller.CabController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CabProApiApplicationTests {

    @Autowired
    private CabController cabController;

    @Test
    void contextLoads() throws Exception {
        assertThat(cabController).isNotNull();
    }

}
