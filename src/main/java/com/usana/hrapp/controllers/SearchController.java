package com.usana.hrapp.controllers;

import com.usana.hrapp.models.Employee;
import com.usana.hrapp.models.EmployeeSearch;
import com.usana.hrapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping
    public String showSearchPage(Model model) {
        return "search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String findEmployees(EmployeeSearch employeeSearch, RedirectAttributes attr) {
        List<Employee> foundEmployees = employeeService.findEmployees(employeeSearch);

        attr.addFlashAttribute("first", employeeSearch.getFirstName());
        attr.addFlashAttribute("last",  employeeSearch.getLastName());
        attr.addFlashAttribute("start", employeeSearch.getStartDate());
        attr.addFlashAttribute("id",    employeeSearch.getId() != null ? employeeSearch.getId() : "");
        attr.addFlashAttribute("found", foundEmployees);
        attr.addFlashAttribute("hit", true);

        return "redirect:/search";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String updateEmployee(@RequestBody MultiValueMap<String,String> body) {
        Employee employee = new Employee();
        employee.setFirstName(body.getFirst("firstName"));
        employee.setLastName(body.getFirst("lastName"));
        employee.setAddress1(body.getFirst("address1"));
        employee.setAddress2(body.getFirst("address2"));
        employee.setCity(body.getFirst("city"));
        employee.setState(body.getFirst("state"));
        employee.setZip(body.getFirst("zip"));
        employee.setPhone(body.getFirst("phone"));
        employee.setId(Integer.parseInt(body.getFirst("id")));
        employeeService.updateEmployee(employee);
        return "{success:true}";
    }

}
