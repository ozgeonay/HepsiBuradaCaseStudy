package com.development.hepsiburadacase;

import com.development.hepsiburadacase.controller.RoverController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HepsiburadacaseApplicationTests {

    @Autowired
    private RoverController controller;

    @Test
    void contextLoads() {
        Assertions.assertThat(controller).isNotNull();
    }

}
