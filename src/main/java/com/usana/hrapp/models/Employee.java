package com.usana.hrapp.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @NotEmpty
    private String firstName;
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @NotEmpty
    private String lastName;
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @NotEmpty
    private String address1;
    public String getAddress1() { return address1; }
    public void setAddress1(String address1) { this.address1 = address1; }

    private String address2;
    public String getAddress2() { return address2; }
    public void setAddress2(String address2) { this.address2 = address2; }

    @NotEmpty
    private String city;
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @NotEmpty
    private String state;
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    @NotEmpty
    private String zip;
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    @NotEmpty
    private String phone;
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date startDate;
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

}
