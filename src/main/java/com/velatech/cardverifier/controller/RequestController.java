package com.velatech.cardverifier.controller;


import com.velatech.cardverifier.dto.clientResponse.ClientResponse;
import com.velatech.cardverifier.dto.statPackage.StatResponse;
import com.velatech.cardverifier.service.CardService;
import com.velatech.cardverifier.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/card-scheme")
@RestController
public class RequestController {

    @Autowired
    private CardService verifyCard;

    @Autowired
    private QueryService queryService;


    @GetMapping("/verify/{cardNumber}")
    public ClientResponse getCardDetails(@PathVariable("cardNumber") String cardNumber) {
        return verifyCard.verifyCard(cardNumber);
    }


    @GetMapping(value = "/stats", params = {"start", "limit"})
    public ResponseEntity<StatResponse> getStats(@RequestParam("start") int start, @RequestParam("limit") int limit) {
//        return  queryService.getStatStructure(PageRequest.of(start, limit) );
        if(start >= 1) start--;
        return new ResponseEntity<>(queryService.getStatStructure(PageRequest.of(start, limit)), HttpStatus.OK);
    }
}
