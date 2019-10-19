package com.rxx.coffeejourney.dao;

import com.rxx.coffeejourney.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {

    public List<Employee> getAll () {
        return null;
    }

    public String save (Employee employee) {
        return "successful";
    }

    public Employee getEmployee (Integer id) {
        return new Employee();
    }

    public String update (Employee employee) {
        return "successful";
    }

    public String delete (Integer id) {
        return id.toString();
    }
}
