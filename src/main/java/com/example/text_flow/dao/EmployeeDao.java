package com.example.text_flow.dao;

import com.example.text_flow.entity.Employee;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao extends BaseDao<Employee> {
    public EmployeeDao() {
        super(Employee.class);
    }
}
