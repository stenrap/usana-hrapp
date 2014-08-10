package com.usana.hrapp.services;


import com.usana.hrapp.models.Employee;
import com.usana.hrapp.models.EmployeeSearch;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee employee);
    public List<Employee> findEmployees(EmployeeSearch employeeSearch);
    public void updateEmployee(Employee employee);

}
