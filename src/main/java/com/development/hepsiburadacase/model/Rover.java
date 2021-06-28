package com.development.hepsiburadacase.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Rover extends Plateau to determine edge of plateau
 */
@Getter
@Setter
public class Rover extends Plateau {
    private static final String EDGE_OF_PLATEAU_ERROR_MSG = "Movement out of the plateau.";
    private int xCoordinate;
    private int yCoordinate;
    private CardinalDirection compassPoint;
    private List<Actions> actionPath;

    /**
     * Gets current location of Rover
     *
     * @return the current location for output
     */
    public String getCurrentLocation() {
        return this.xCoordinate + " " + this.yCoordinate + " " + this.compassPoint.label + "\n";
    }

    /**
     * Instantiates a new Rover with input file lines.
     *
     * @param coordinatesRaw the coordinates raw data which located input file
     * @param actionPathRaw  the action path raw data which located input file
     * @param plateau        the plateau
     */
    public Rover(String coordinatesRaw, String actionPathRaw, Plateau plateau) {
        super(plateau);
        String[] splittedLine = coordinatesRaw.split(" ");

        this.xCoordinate = Integer.valueOf(splittedLine[0]);
        this.yCoordinate = Integer.valueOf(splittedLine[1]);
        this.compassPoint = CardinalDirection.valueOf(splittedLine[2]);
        this.actionPath = actionPathRaw.chars()
                .mapToObj(e -> Actions.valueOf(String.valueOf((char) e)))
                .collect(Collectors.toList());
    }

    /**
     * Move action for Rover, it is decided to new coordinates according to current compass point.
     */
    public void move() {
        switch (this.compassPoint) {
            case N:
                if (super.getYCoordinate() == yCoordinate) {
                    throw new IllegalArgumentException(EDGE_OF_PLATEAU_ERROR_MSG);
                }
                this.yCoordinate++;
                break;
            case S:
                if (super.getYCoordinate() == 0) {
                    throw new IllegalArgumentException(EDGE_OF_PLATEAU_ERROR_MSG);
                }
                this.yCoordinate--;
                break;
            case E:
                if (super.getXCoordinate() == xCoordinate) {
                    throw new IllegalArgumentException(EDGE_OF_PLATEAU_ERROR_MSG);
                }
                this.xCoordinate++;
                break;
            case W:
                if (super.getXCoordinate() == 0) {
                    throw new IllegalArgumentException(EDGE_OF_PLATEAU_ERROR_MSG);
                }
                this.xCoordinate--;
                break;
        }
    }

    /**
     * Action method for Rover
     *
     * @param action the action of rover according to path it can be L,M,R enum variable
     */
    public void action(Actions action) {
        switch (action) {
            case M:
                move();
                break;
            case L:
                this.compassPoint = this.compassPoint.turnLeft();
                break;
            case R:
                this.compassPoint = this.compassPoint.turnRight();
                break;
        }
    }
}
