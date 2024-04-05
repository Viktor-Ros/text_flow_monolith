package com.example.text_flow.service;


import com.example.text_flow.dao.EmployeeDao;
import com.example.text_flow.dao.SubscriptionDao;
import com.example.text_flow.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService extends BaseService<Employee> {

    @Autowired
    private SubscriptionDao subscriptionDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getSubscriberListByWriterId(@PathVariable String writer_id){
        return subscriptionDao.getSubscriptionListByWriterId(writer_id)
                .stream()
                .map(s -> employeeDao.getById(s.getSubscriberId()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Employee> getWriterListBySubscriberId(String subscriber_id){
        return subscriptionDao.getSubscriptionListBySubscriberId(subscriber_id)
                .stream()
                .map(s -> employeeDao.getById(s.getWriterId()))
                .collect(Collectors.toList());
    }
}
