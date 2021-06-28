package com.development.hepsiburadacase.file;


import com.development.hepsiburadacase.model.FileModel;
import com.development.hepsiburadacase.model.Plateau;
import com.development.hepsiburadacase.model.Rover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Data ımporter class is used for reading file to write a model
 */
@Slf4j
@Service
public class DataImporter {


    /**
     * Read file to write FileModel
     *
     * @return the FileModel which includes Plateau and Rover List
     * @throws IOException if input file cannot read or input file format not proper
     */
    public FileModel readFile() throws IOException {
        FileModel fileModel = new FileModel();
        try (InputStream resourceStream = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt")) {
            if (resourceStream != null) {
                List<Rover> roverList = new ArrayList<>();
                fileModel.setRoverList(roverList);
                BufferedReader resReader = new BufferedReader(new InputStreamReader(resourceStream));
                fileModel.setPlateau(new Plateau(resReader.readLine()));

                while (resReader.ready()) {
                    Rover rover = new Rover(resReader.readLine(), resReader.readLine(), fileModel.getPlateau());
                    fileModel.getRoverList().add(rover);
                }
            }
        } catch (IOException | NullPointerException e) {
            log.error("file read error", e);
            throw new IOException(e);
        }
        return fileModel;
    }
}
