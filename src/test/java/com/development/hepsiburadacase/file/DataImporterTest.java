package com.development.hepsiburadacase.file;

import com.development.hepsiburadacase.model.CardinalDirection;
import com.development.hepsiburadacase.model.FileModel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Data ımporter test.
 */
class DataImporterTest {

    private DataImporter dataImporterUnderTest;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dataImporterUnderTest = new DataImporter();

    }

    /**
     * Read file with success test. Input file read from test resources.
     */
    @SneakyThrows
    @Test
    void readFileWithSuccess() {

        FileModel fileModel = dataImporterUnderTest.readFile();
        assertThat(fileModel.getPlateau().getXCoordinate()).isEqualTo(5);
        assertThat(fileModel.getPlateau().getYCoordinate()).isEqualTo(5);
        assertThat(fileModel.getRoverList().size()).isEqualTo(2);
        assertThat(fileModel.getRoverList().get(0).getXCoordinate()).isEqualTo(1);
        assertThat(fileModel.getRoverList().get(0).getYCoordinate()).isEqualTo(2);
        assertThat(fileModel.getRoverList().get(0).getCompassPoint()).isEqualTo(CardinalDirection.N);
        assertThat(fileModel.getRoverList().get(0).getActionPath().size()).isEqualTo(9);
        assertThat(fileModel.getRoverList().get(1).getXCoordinate()).isEqualTo(3);
        assertThat(fileModel.getRoverList().get(1).getYCoordinate()).isEqualTo(3);
        assertThat(fileModel.getRoverList().get(1).getCompassPoint()).isEqualTo(CardinalDirection.E);
        assertThat(fileModel.getRoverList().get(1).getActionPath().size()).isEqualTo(10);
    }

}