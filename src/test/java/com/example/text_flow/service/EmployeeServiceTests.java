package com.example.text_flow.service;

import com.example.text_flow.entity.Employee;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.text_flow.utils.TestData.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTests {

    @Autowired
    EmployeeService employeeService;


    @Test()
    @Order(1)
    public void getSubscriberListByWriterId(){
        List<Employee> employeeList = employeeService.getSubscriberListByWriterId(EMP_1_ID);

        Assertions.assertNotNull(employeeList, "Subscriber list by writer id is NULL");
        Assertions.assertNotEquals(employeeList.size(), 0, "Subscriber list by writer id is EMPTY");
        Assertions.assertEquals(employeeList.size(), EMP_LIST_BY_WRITER_SIZE, "Subscriber list by writer id is WRONG size");
    }

    @Test()
    @Order(2)
    public void getWriterListBySubscriberId(){
        List<Employee> employeeList = employeeService.getWriterListBySubscriberId(EMP_3_ID);

        Assertions.assertNotNull(employeeList, "Writer list by subscriber id is NULL");
        Assertions.assertNotEquals(employeeList.size(), 0, "Writer list by subscriber id is EMPTY");
        Assertions.assertEquals(employeeList.size(), EMP_LIST_BY_SUBSCRIBER_SIZE, "Writer list by subscriber id is WRONG size");

    }

}
