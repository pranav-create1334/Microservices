package com.Pranav_Kusalkar.Department_Service.Controller;

import com.Pranav_Kusalkar.Department_Service.Model.Department;
import com.Pranav_Kusalkar.Department_Service.Repository.Department_Repo;
import com.Pranav_Kusalkar.Department_Service.client.EmployeeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/department")
public class Department_Controller {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(Department_Controller.class);
    @Autowired
    private Department_Repo repository;
    @Autowired
    private EmployeeClient employeeClient;
    public Department_Controller(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return repository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        LOGGER.info("Department find: id={}", id);
        return repository.findById(id);
    }
    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees()
    {
        LOGGER.info("Department find");
        List<Department> departments
                = repository.findAll();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.findByDepartment(department.getId())));
        return  departments;
    }

}