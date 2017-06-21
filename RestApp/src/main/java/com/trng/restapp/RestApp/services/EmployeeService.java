package com.trng.restapp.RestApp.services;

import java.util.List;


import com.trng.restapp.RestApp.Model.Employee;


public interface EmployeeService {
	public Employee getEmployee(String empId);
	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public String deleteEmployee(String empId);
	public List<Employee> getEmployees();

}
