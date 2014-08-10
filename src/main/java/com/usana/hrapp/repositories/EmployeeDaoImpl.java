package com.usana.hrapp.repositories;

import com.usana.hrapp.models.Employee;
import com.usana.hrapp.models.EmployeeSearch;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public List<Employee> findEmployees(EmployeeSearch employeeSearch) {
        String first = employeeSearch.getFirstName().length() > 0 ? "%"+employeeSearch.getFirstName()+"%" : "";
        String last  = employeeSearch.getLastName().length()  > 0 ? "%"+employeeSearch.getLastName()+"%"  : "";
        String start = employeeSearch.getStartDate().length() > 0 ? "%"+employeeSearch.getStartDate()+"%" : "";

        return sessionFactory.getCurrentSession()
                .createQuery("FROM Employee employee WHERE employee.firstName LIKE :first OR employee.lastName LIKE :last OR employee.startDate LIKE :start OR employee.id LIKE :id")
                .setParameter("first", first)
                .setParameter("last", last)
                .setString("start", start)
                .setParameter("id", employeeSearch.getId())
                .list();
    }

    @Override
    public void updateEmployee(Employee employee) {
        Query query = sessionFactory.getCurrentSession()
                        .createQuery("UPDATE Employee employee SET employee.firstName = :first, " +
                                                                  "employee.lastName  = :last, " +
                                                                  "employee.address1  = :addOne, " +
                                                                  "employee.address2  = :addTwo, " +
                                                                  "employee.city      = :city, " +
                                                                  "employee.state     = :state, " +
                                                                  "employee.zip       = :zip, " +
                                                                  "employee.phone     = :phone " +
                                                            "WHERE employee.id        = :id");

        query.setParameter("first", employee.getFirstName());
        query.setParameter("last", employee.getLastName());
        query.setParameter("addOne", employee.getAddress1());
        query.setParameter("addTwo", employee.getAddress2());
        query.setParameter("city", employee.getCity());
        query.setParameter("state", employee.getState());
        query.setParameter("zip", employee.getZip());
        query.setParameter("phone", employee.getPhone());
        query.setParameter("id", employee.getId());

        query.executeUpdate();
    }

}
