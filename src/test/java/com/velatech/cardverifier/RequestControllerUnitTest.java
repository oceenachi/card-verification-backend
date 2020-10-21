//package com.velatech.cardverifier;
//
//import com.velatech.cardverifier.controller.RequestController;
//import com.velatech.cardverifier.dto.clientResponse.ClientPayload;
//import com.velatech.cardverifier.dto.clientResponse.ClientResponse;
//import com.velatech.cardverifier.dto.statPackage.StatResponse;
//import com.velatech.cardverifier.service.CardService;
//import com.velatech.cardverifier.service.QueryService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//public class RequestControllerUnitTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    CardService cardService;
//
//    @MockBean
//    QueryService queryService;
//
//    @Autowired
//    RequestController requestController;
//
//    @Before
//    public void createMock(){
//        ClientResponse clientResponse = new ClientResponse();
//        ClientPayload clientPayload = new ClientPayload();
//
//        clientResponse.setPayload(clientPayload);
//        clientPayload.setScheme("visa");
//        clientPayload.setType("Debit");
//        clientPayload.setBank("Jsyke Bank");
//        clientPayload.setName("Denmark");
//        clientPayload.setEmoji("US");
//
//        given(cardService.verifyCard(any())).willReturn(clientResponse);
//    }
//
//    @Before
//    public void statSetup(){
//        StatResponse statResponse = new StatResponse();
//        Map<String, Object> payload = new HashMap<>();
//
//        payload.put("423342", 1);
//        payload.put("432514", 4);
//
//        statResponse.setPayload(payload);
//        statResponse.setSize((long) 23);
//        statResponse.setLimit(8);
//        statResponse.setStart(3);
//
//        given(queryService.getStatStructure(any())).willReturn(statResponse);
//
//    }
//
//    @Test
//    public void getCardDetails() throws Exception{
//        mockMvc.perform(get("/card-scheme/verify/423342"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json("{}"));
//        verify(cardService, times(1)).verifyCard("423342");
//    }
//
//
//    @Test
//    public void getStats() throws Exception{
//        mockMvc.perform(get("/card-scheme/stats?start=1&limit=5"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//}
