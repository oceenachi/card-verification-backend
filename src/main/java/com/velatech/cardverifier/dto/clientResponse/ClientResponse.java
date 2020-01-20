package com.velatech.cardverifier.dto.clientResponse;

import lombok.Data;

@Data
public class ClientResponse {

    private boolean success;
    private ClientPayload payload;
}
