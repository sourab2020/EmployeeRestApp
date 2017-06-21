package com.trng.restapp.RestApp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trng.restapp.RestApp.Model.Employee;
import com.trng.restapp.RestApp.services.EmployeeService;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	final static Logger logger = Logger.getLogger(EmployeeController.class);

	@RequestMapping(value = "/{empId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE })
	public ResponseEntity<?> getEmployee(@PathVariable String empId) {
		Employee employee = employeeService.getEmployee(empId);
		if (employee == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE })
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
	
		
		Employee newEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{empId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable String empId) {
		

		String result = employeeService.deleteEmployee(empId);

		if (result == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Employee updateEmployee(@RequestBody Employee employee) {
		logger.debug("Executing createAccount method");
		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(value="/", method=RequestMethod.GET) 
	public ResponseEntity<List<Employee>> getEmployees() {
		logger.debug("Executing getAccount method");
		List<Employee> employees = employeeService.getEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	
	}
	
}