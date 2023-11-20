package org.cap.demo.controller;

import java.util.List;

import org.cap.demo.pojo.Employee;
import org.cap.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> employees=empService.getEmployees();
		if(employees==null || employees.isEmpty()) {
			return new ResponseEntity("Sorry! Employees not Available!",
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("employeeId")
				Integer empId){
		
		Employee employee=empService.findEmployee(empId);
		
		if(employee==null ) {
			return new ResponseEntity("Sorry! Employees Id Not Found!",
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("employeeId")
				Integer empId){
		
		List<Employee> employees=empService.deleteEmployee(empId);
		
		if(employees==null ) {
			return new ResponseEntity("Sorry! Employees Id Not Found!",
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	
	@PostMapping("/employees")
	public ResponseEntity<List<Employee>> createEmployee
				(@RequestBody Employee employee){
		List<Employee> employees=empService.createEmployee(employee);
		if(employees==null) {
			return new ResponseEntity("Sorry! Insertion Failed!",
					HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	
	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<List<Employee>> updateEmployee
				(@RequestBody Employee employee,
						@PathVariable("employeeId") Integer empId){
		
		List<Employee> employees=empService.createEmployee(employee);
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	
}
