package com.usana.hrapp.controllers;

import com.usana.hrapp.models.Employee;
import com.usana.hrapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class CreateEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping
    public String showEmployeeCreationPage() {
        return "create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createNewEmployee(@Valid @ModelAttribute Employee employee, BindingResult result) {
        if (!result.hasErrors()) {
            employeeService.addEmployee(employee);
        }
        return "redirect:/";
    }

}
