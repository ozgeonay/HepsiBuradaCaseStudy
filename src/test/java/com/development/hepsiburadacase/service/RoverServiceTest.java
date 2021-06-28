package com.development.hepsiburadacase.service;

import com.development.hepsiburadacase.file.DataImporter;
import com.development.hepsiburadacase.model.FileModel;
import com.development.hepsiburadacase.model.Plateau;
import com.development.hepsiburadacase.model.ResponseModel;
import com.development.hepsiburadacase.model.Rover;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RoverServiceTest {

    @Mock
    private DataImporter dataImporter;

    private RoverService roverServiceUnderTest;
    FileModel fileModel = new FileModel();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        roverServiceUnderTest = new RoverService(dataImporter);

    }

    @SneakyThrows
    @Test
    void processActionsWithSuccess() {
        Plateau plateau = new Plateau("5 5");
        Rover rover = new Rover("1 2 N", "LMLMLMLMM", plateau);
        List<Rover> roverList = new ArrayList<>();
        roverList.add(rover);
        fileModel.setRoverList(roverList);
        fileModel.setPlateau(plateau);

        when(dataImporter.readFile()).thenReturn(fileModel);
        ResponseModel responseModel = roverServiceUnderTest.processActions();

        assertThat(responseModel.isSuccess()).isTrue();
        assertThat(responseModel.getMessageText()).isEqualTo("Success process.");
        assertThat(fileModel.getRoverList().get(0).getCurrentLocation()).isEqualTo("1 3 N\n");

    }

    @SneakyThrows
    @Test
    void processActionsWithIOExteption() {

        when(dataImporter.readFile()).thenThrow(new IOException());
        ResponseModel responseModel = roverServiceUnderTest.processActions();

        assertThat(responseModel.isSuccess()).isFalse();
        assertThat(responseModel.getMessageText()).isEqualTo("Input file read exception!");

    }

    @SneakyThrows
    @Test
    void processActionsWithIllegalArgumentException() {
        Plateau plateau = new Plateau("5 2");
        Rover rover = new Rover("1 2 N", "LMLMLMLMM", plateau);
        List<Rover> roverList = new ArrayList<>();
        roverList.add(rover);
        fileModel.setRoverList(roverList);
        fileModel.setPlateau(plateau);

        when(dataImporter.readFile()).thenReturn(fileModel);
        ResponseModel responseModel = roverServiceUnderTest.processActions();

        assertThat(responseModel.isSuccess()).isFalse();
        assertThat(responseModel.getMessageText()).isEqualTo("Movement out of the plateau.");
        assertThat(fileModel.getRoverList().get(0).getCurrentLocation()).isEqualTo("1 2 N\n");


    }

}