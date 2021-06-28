package com.development.hepsiburadacase.service;


import com.development.hepsiburadacase.file.DataImporter;
import com.development.hepsiburadacase.model.FileModel;
import com.development.hepsiburadacase.model.ResponseModel;
import com.development.hepsiburadacase.model.Rover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The type Rover service process rovers actions.
 */
@Slf4j
@Service
public class RoverService {

    /**
     * The Data ımporter autowired for reading input file
     */
    DataImporter dataImporter;

    /**
     * Instantiates a new Rover service with data importer
     *
     * @param dataImporter the data ımporter
     */
    @Autowired
    public RoverService(DataImporter dataImporter) {
        this.dataImporter = dataImporter;
    }

    /**
     * Process actions of rover and return process status with response model
     *
     * @return the response model
     */
    public ResponseModel processActions() {
        ResponseModel responseModel = new ResponseModel();
        FileModel fileModel = null;
        try {
            fileModel = dataImporter.readFile();
        } catch (IOException e) {
            log.error("Input file read exception!");
            responseModel.setMessageText("Input file read exception!");
            return responseModel;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", false))) {
            for (Rover rover : fileModel.getRoverList()) {
                rover.getActionPath().forEach(action -> rover.action(action));
                writer.append(rover.getCurrentLocation());
                log.info(rover.getCurrentLocation());
            }
        } catch (IOException e) {
            log.error("Output write exception: ", e);
            responseModel.setMessageText("Internal Service Exception.");
            return responseModel;
        } catch (IllegalArgumentException e) {
            log.error("Movement out of the plateau!");
            responseModel.setMessageText("Movement out of the plateau.");
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessageText("Success process.");
        return responseModel;
    }
}
