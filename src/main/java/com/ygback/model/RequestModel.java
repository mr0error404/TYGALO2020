package com.ygback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestModel {
    private boolean success;
    private DataModel data;
    private String message;

}
