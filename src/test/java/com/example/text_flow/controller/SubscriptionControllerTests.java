package com.example.text_flow.controller;

import com.example.text_flow.entity.Subscription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.example.text_flow.utils.TestData.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubscriptionControllerTests {

    @Autowired
    MockMvc mockMvc;

    private static String SUB_ID_NEW;


    @Test
    @Order(1)
    public void saveSubscription() throws Exception {
        MvcResult result = mockMvc.perform(post("/subscription").content(new ObjectMapper().writeValueAsString((new Subscription(EMP_1_ID, EMP_2_ID))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andReturn();

        SUB_ID_NEW = JsonPath.parse( result.getResponse().getContentAsString()).read("$.id");
    }

    @Test
    @Order(2)
    public void updateSubscription() throws Exception {
        Subscription updatedSubscription = new Subscription();
        updatedSubscription.setId(SUB_ID_NEW);
        updatedSubscription.setWriterId(EMP_1_ID);
        updatedSubscription.setSubscriberId(EMP_3_ID);


        mockMvc.perform(put("/subscription").content(new ObjectMapper().writeValueAsString((updatedSubscription)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(SUB_ID_NEW)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.writerId", is(EMP_1_ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subscriberId", is(EMP_3_ID)));
    }

    @Test
    @Order(3)
    public void deleteSubscriptionById() throws Exception {
        mockMvc.perform(delete("/subscription/" + SUB_ID_NEW)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Subscription.class.getName() + " with id = " + SUB_ID_NEW + " successfully DELETED"));
    }

    @Test
    @Order(4)
    public void getSubscriptionById() throws Exception {
        mockMvc.perform(get("/subscription/" + SUB_1_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(SUB_1_ID))
                .andExpect(jsonPath("$.writerId").value(EMP_1_ID))
                .andExpect(jsonPath("$.subscriberId").value(EMP_2_ID));
    }

    @Test
    @Order(5)
    public void getAllSubscription() throws Exception {
        mockMvc.perform(get("/subscription")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(SUB_ALL_LIST_SIZE));
    }

}
