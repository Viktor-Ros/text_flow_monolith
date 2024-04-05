package com.example.text_flow.controller;

import com.example.text_flow.entity.Employee;
import com.example.text_flow.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController<Employee> {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/subscriber_list_by_writer_id/{writer_id}")
    public List<Employee> getSubscriberListByWriterId(@PathVariable String writer_id){
        return employeeService.getSubscriberListByWriterId(writer_id);
    }

    @GetMapping("/writer_list_by_subscriber_id/{subscriber_id}")
    public List<Employee> getWriterListBySubscriberId(@PathVariable String subscriber_id){
        return employeeService.getWriterListBySubscriberId(subscriber_id);
    }

}
