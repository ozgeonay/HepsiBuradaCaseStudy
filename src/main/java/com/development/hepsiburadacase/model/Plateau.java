package com.development.hepsiburadacase.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Plateau which located Mars
 */
@Getter
@Setter
public class Plateau {
    private int xCoordinate;
    private int yCoordinate;

    /**
     * Instantiates a new Plateau with int coordinates.
     *
     * @param xCoordinate the x coordinate
     * @param yCoordinate the y coordinate
     */
    public Plateau(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Instantiates a new Plateau with specific plateau
     *
     * @param plateau the plateau
     */
    public Plateau(Plateau plateau) {
        this.xCoordinate = plateau.getXCoordinate();
        this.yCoordinate = plateau.getYCoordinate();
    }

    /**
     * Instantiates a new Plateau with input line raw date
     *
     * @param rawData the raw data which located in input file first line.
     */
    public Plateau(String rawData) {
        String[] splittedLine = rawData.split(" ");
        this.xCoordinate = Integer.valueOf(splittedLine[0]);
        this.yCoordinate = Integer.valueOf(splittedLine[1]);
    }
}
