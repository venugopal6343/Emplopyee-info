package com.ust.Employee_info.service;

import com.ust.Employee_info.model.Employee;
import com.ust.Employee_info.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;


    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> addEmployees(List<Employee> employees) {
        return repo.saveAll(employees);
    }

    public Employee getEmployee(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        repo.deleteById(id);
        return ("Deleted employee with id "+ id);
    }

    public Employee updateEmployee(int id, Employee employeeClass) {
        Employee existingEmployee = repo.findById(id)
                .orElse(null);
        Objects.requireNonNull(existingEmployee).setName(employeeClass.getName());
        existingEmployee.setSalary(employeeClass.getSalary());
        existingEmployee.setGrade(employeeClass.getGrade());
        return repo.save(existingEmployee);
    }

    public List<Employee> listEmployees() {
        return repo.findAll();
    }

}
