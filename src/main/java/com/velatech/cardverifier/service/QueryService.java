package com.velatech.cardverifier.service;

import com.velatech.cardverifier.dto.statPackage.StatResponse;
import com.velatech.cardverifier.exception.recordNotFoundException;
import com.velatech.cardverifier.repository.CardInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueryService {

    private static final Logger log = LoggerFactory.getLogger(QueryService.class);

    @Autowired
    private CardInfoRepository cardInfoRepository;

    public StatResponse getStatStructure(Pageable pageable) {

        StatResponse statResponse = new StatResponse();

        int size = cardInfoRepository.findAll().size();

        Page<Map<String, Object>> newPayload= cardInfoRepository.getUniqueCards(pageable);

        statResponse.setSuccess(true);
        statResponse.setStart(newPayload.getNumber() + 1);
        statResponse.setLimit(newPayload.getSize());
        statResponse.setSize((long) size);

        if(newPayload.hasContent()) {
            Map<String, Object> payload = new HashMap<>();

            for(Map<String, Object> payloadSet: newPayload) {
                payload.put(String.valueOf(payloadSet.get("cardNum")), Integer.parseInt(String.valueOf(payloadSet.get("count"))));
            }
            statResponse.setPayload(payload);
        }
        else{
            throw new recordNotFoundException("No records found within the specified range");
        }

        return statResponse;
    }

}
