package com.example.text_flow.controller;

import com.example.text_flow.entity.Employee;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTests {

    @Autowired
    MockMvc mockMvc;

    private static String EMP_ID_NEW;


    @Test
    @Order(1)
    public void saveEmployee() throws Exception {
        MvcResult result = mockMvc.perform(post("/employee").content(new ObjectMapper().writeValueAsString((new Employee(EMP_NAME_NEW))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andReturn();

        EMP_ID_NEW = JsonPath.parse( result.getResponse().getContentAsString()).read("$.id");
    }

    @Test
    @Order(2)
    public void updateEmployee() throws Exception {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(EMP_ID_NEW);
        updatedEmployee.setName(EMP_NAME_UPDATE);


        mockMvc.perform(put("/employee").content(new ObjectMapper().writeValueAsString((updatedEmployee)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(EMP_ID_NEW)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(EMP_NAME_UPDATE)));
    }

    @Test
    @Order(3)
    public void deleteEmployeeById() throws Exception {
        mockMvc.perform(delete("/employee/" + EMP_ID_NEW)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Employee.class.getName() + " with id = " + EMP_ID_NEW + " successfully DELETED"));
    }

    @Test
    @Order(4)
    public void getEmployeeById() throws Exception {
        mockMvc.perform(get("/employee/" + EMP_1_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(EMP_1_ID))
                .andExpect(jsonPath("$.name").value(EMP_1_NAME));
    }

    @Test
    @Order(5)
    public void getAllEmployee() throws Exception {
        mockMvc.perform(get("/employee")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(EMP_ALL_LIST_SIZE));
    }

    @Test
    @Order(6)
    public void getSubscriberListByWriterId() throws Exception {
        mockMvc.perform(get("/employee/subscriber_list_by_writer_id/" + EMP_1_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(EMP_LIST_BY_WRITER_SIZE));
    }

    @Test
    @Order(7)
    public void getWriterListBySubscriberId() throws Exception {
        mockMvc.perform(get("/employee/writer_list_by_subscriber_id/" + EMP_3_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(EMP_LIST_BY_SUBSCRIBER_SIZE));
    }

}
