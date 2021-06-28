package com.development.hepsiburadacase.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Response model for endpoint.
 */
@Getter
@Setter
public class ResponseModel {
    private boolean success;
    private String messageText;
}
