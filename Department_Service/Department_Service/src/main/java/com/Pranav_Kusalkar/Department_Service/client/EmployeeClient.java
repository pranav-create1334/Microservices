package com.Pranav_Kusalkar.Department_Service.client;

import com.Pranav_Kusalkar.Department_Service.Model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/employees/department/{departmentId}")
    List<Employee> findByDepartment(@PathVariable Long departmentId);
}
