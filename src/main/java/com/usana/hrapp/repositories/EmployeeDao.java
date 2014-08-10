package com.usana.hrapp.repositories;

import com.usana.hrapp.models.Employee;
import com.usana.hrapp.models.EmployeeSearch;

import java.util.List;

public interface EmployeeDao {

    public void addEmployee(Employee employee);
    public List<Employee> findEmployees(EmployeeSearch employeeSearch);
    public void updateEmployee(Employee employee);

}
