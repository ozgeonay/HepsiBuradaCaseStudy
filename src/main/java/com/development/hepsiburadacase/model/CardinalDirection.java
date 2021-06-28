package com.development.hepsiburadacase.model;

/**
 * The enum Cardinal directions.
 */
public enum CardinalDirection {

    /**
     * N cardinal direction for North
     */
    N("N"),
    /**
     * S cardinal direction for South
     */
    S("S"),
    /**
     * E cardinal direction for East
     */
    E("E"),
    /**
     * W cardinal direction for West
     */
    W("W");

    private CardinalDirection left;
    private CardinalDirection right;


    static {
        N.left = W;
        S.left = E;
        E.left = N;
        W.left = S;
        N.right = E;
        S.right = W;
        E.right = S;
        W.right = N;
    }

    /**
     * Turn left cardinal direction.
     *
     * @return the cardinal direction which located left
     */
    public CardinalDirection turnLeft() {
        return left;
    }

    /**
     * Turn right cardinal direction.
     *
     * @return the cardinal direction which located right
     */
    public CardinalDirection turnRight() {
        return right;
    }

    /**
     * The Label for directions.
     */
    public final String label;

    private CardinalDirection(String label) {
        this.label = label;
    }

}

