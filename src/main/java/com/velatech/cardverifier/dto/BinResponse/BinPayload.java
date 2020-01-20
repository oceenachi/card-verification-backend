package com.velatech.cardverifier.dto.BinResponse;

import lombok.Builder;
import lombok.Data;

@Data
public class BinPayload {

    private BinNumber number;
    private String scheme;
    private String type;
    private Country country;
    private Bank bank;
}
