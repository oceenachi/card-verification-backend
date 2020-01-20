package com.velatech.cardverifier.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cardNum;

    private String scheme;

    private String type;

    private String bank;

    private int length;

    private boolean success;


}
