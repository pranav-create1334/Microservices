package com.example.Employee_service.controller;

import com.example.Employee_service.model.Employee;
import com.example.Employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger log =
            LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        log.info("Employee add: {}", employee);
        return repository.add(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        log.info("Employee find all");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        log.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(
            @PathVariable("departmentId") Long departmentId) {
        log.info("Employee find: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }
}
