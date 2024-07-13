package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	private static final double MINIMUM_SALARY = 30000;
	
	 @Autowired
	    public EmployeeService(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }
	 
	 
	   public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Optional<Employee> getEmployeeById(Long id) {
	        return employeeRepository.findById(id);
	    }

		
		/*
		 * public Employee saveEmployee(Employee employee) {
		 * validateSalary(employee.getSalary()); return
		 * employeeRepository.save(employee); }
		 */
		 
	    
	    public Employee saveEmployee(Employee employee) {
	    	 validateSalary(employee.getSalary());
	        return employeeRepository.save(employee);
	    }

	    public void deleteEmployee(Long id) {
	    	employeeRepository.deleteById(id);
	    }
	 
	    private void validateSalary(double salary) {
	        if (salary < MINIMUM_SALARY) {
	            throw new IllegalArgumentException("Salary must be above " + MINIMUM_SALARY);
	        }
	    }
}
