package com.Pranav_Kusalkar.Department_Service.service;

import com.Pranav_Kusalkar.Department_Service.Model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class DepartmentService {

    private final WebClient webClient;

    public DepartmentService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://employee-service")
                .build();
    }

    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return webClient.get()
                .uri("/employee/department/{id}", departmentId)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
                .block();
    }
}
