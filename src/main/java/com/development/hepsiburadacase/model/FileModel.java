package com.development.hepsiburadacase.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The type File model which readed from input file.
 */
@Getter
@Setter
public class FileModel {
    private Plateau plateau;
    private List<Rover> roverList;
}
