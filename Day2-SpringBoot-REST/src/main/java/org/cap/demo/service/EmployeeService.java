package org.cap.demo.service;

import java.util.List;

import org.cap.demo.pojo.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public Employee findEmployee(int employeeId);
	
	public List<Employee> deleteEmployee(int employeeId);
	
	public List<Employee> createEmployee(Employee employee);

}
