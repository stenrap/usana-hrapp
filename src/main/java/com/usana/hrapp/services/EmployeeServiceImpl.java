package com.usana.hrapp.services;

import com.usana.hrapp.models.EmployeeSearch;
import com.usana.hrapp.repositories.EmployeeDao;
import com.usana.hrapp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> findEmployees(EmployeeSearch employeeSearch) {
        return employeeDao.findEmployees(employeeSearch);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

}
