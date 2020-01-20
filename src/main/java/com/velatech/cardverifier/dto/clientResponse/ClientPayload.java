package com.velatech.cardverifier.dto.clientResponse;

import lombok.Data;

@Data
public class ClientPayload {

    private String scheme;
    private String type;
    private String bank;
    private String name;
    private String emoji;

}
