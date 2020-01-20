package com.velatech.cardverifier.dto.BinResponse;

import lombok.Data;


@Data
public class BinNumber {

    private int length;
    private boolean luhn;
}
