package com.velatech.cardverifier.service;

import com.velatech.cardverifier.dto.BinResponse.BinPayload;
import com.velatech.cardverifier.dto.clientResponse.ClientPayload;
import com.velatech.cardverifier.dto.clientResponse.ClientResponse;
import com.velatech.cardverifier.exception.CardNumberNotFound;
import com.velatech.cardverifier.model.CardInfo;
import com.velatech.cardverifier.repository.CardInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CardInfoRepository cardInfoRepository;

    private ClientResponse clientResponse;


    public ClientResponse verifyCard(String cardNumber){

        final String uri = "https://lookup.binlist.net/{cardNumber}";

        try {

            BinPayload result = restTemplate.getForObject(uri, BinPayload.class, cardNumber);
            cardInfoRepository.save(setCardInfo(result, cardNumber));
            return createResponse(result);
        }
        catch(Exception e){
            throw new CardNumberNotFound("Card number '"+ cardNumber + "' cannot be found");
        }

    }

    public ClientResponse createResponse(BinPayload outcome) {

        ClientPayload clientPayload = new ClientPayload();
        ClientResponse clientResponse = new ClientResponse();

        clientPayload.setBank(outcome.getBank().getName());
        clientPayload.setScheme(outcome.getScheme());
        clientPayload.setType(outcome.getType());
        clientPayload.setName(outcome.getCountry().getName());
        clientPayload.setEmoji(outcome.getCountry().getEmoji());

        clientResponse.setSuccess(outcome.getNumber().isLuhn());
        clientResponse.setPayload(clientPayload);

        return clientResponse;
    }

    public CardInfo setCardInfo(BinPayload outcome, String cardNumber){
        CardInfo cardInfo = new CardInfo();

        if(cardNumber.length() > 6) {
            cardInfo.setCardNum(cardNumber.substring(0, 6));
        }else{
            cardInfo.setCardNum(cardNumber);
        }
        cardInfo.setBank(outcome.getBank().getName());
        cardInfo.setScheme(outcome.getScheme());
        cardInfo.setType(outcome.getType());
        cardInfo.setSuccess(outcome.getNumber().isLuhn());
        cardInfo.setLength(outcome.getNumber().getLength());

        return cardInfo;
    }

}
