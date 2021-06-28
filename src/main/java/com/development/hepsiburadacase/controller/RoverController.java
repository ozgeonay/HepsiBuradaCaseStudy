package com.development.hepsiburadacase.controller;

import com.development.hepsiburadacase.model.ResponseModel;
import com.development.hepsiburadacase.service.RoverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Rover controller includes rover process endpoint
 */
@Controller
@Slf4j
@RequestMapping("/api")
public class RoverController {

    /**
     * The Rover service for processing rover actions.
     */
    RoverService roverService;

    /**
     * Instantiates a new Rover controller.
     *
     * @param roverService the rover service
     */
    @Autowired
    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    /**
     * The endpoint to process rover actions according to input file
     *
     * @return the response entity for understanding process is success or not.
     */
    @GetMapping("/process-rover")
    public ResponseEntity<ResponseModel> processRover() {
        ResponseModel responseModel = roverService.processActions();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}
