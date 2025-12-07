package com.example.college_hub.model;

import java.io.Serializable;


public class Status implements Serializable {
    private static final long serialVersionUID = -2286093091932945756L;
    private StatusCode statusCode;
    private String statusReason;

    private enum StatusCode {
        ACTIVE, INACTIVE, PENDING, LEFT, SUSPENDED
    }
}
