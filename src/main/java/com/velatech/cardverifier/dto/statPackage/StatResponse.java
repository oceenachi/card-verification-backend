package com.velatech.cardverifier.dto.statPackage;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class StatResponse {

    private boolean success;
    private int start;
    private int limit;
    private Long size;
    private Map<String, Object> payload= new HashMap<>();


}
