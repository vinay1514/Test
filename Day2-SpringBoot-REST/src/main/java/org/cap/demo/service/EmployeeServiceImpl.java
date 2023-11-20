package org.cap.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.cap.demo.pojo.Employee;
import org.springframework.stereotype.Service;


@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	private static AtomicInteger empId=new AtomicInteger(0);
	private static List<Employee> employees;
	
	static {
		employees=dummyEmployeeList();
	}

	@Override
	public List<Employee> getEmployees() {
		
		return employees;
	}

	private static List<Employee> dummyEmployeeList() {
		
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee(empId.getAndIncrement(), "Tom", "Jerry", 12000));
		employees.add(new Employee(empId.getAndIncrement(), "Neha", "Jercy", 20001));
		employees.add(new Employee(empId.getAndIncrement(), "India", "India", 34000));
		employees.add(new Employee(empId.getAndIncrement(), "Senthil", "Srividhya", 78000));
		employees.add(new Employee(empId.getAndIncrement(), "Srinivas", "K", 45000));
		employees.add(new Employee(empId.getAndIncrement(), "Jeswanth", "Sinha", 33000));
		return employees;
	}

	@Override
	public Employee findEmployee(int employeeId) {
		
		for(Employee emp:employees) {
			if(emp.getEmpId() == employeeId)
				return emp;
		}
		
		return null;
	}

	@Override
	public List<Employee> deleteEmployee(int employeeId) {
		
		Iterator<Employee> iterator= employees.iterator();
		int totalSize=employees.size();
		
		while(iterator.hasNext()) {
			Employee employee=iterator.next();
			if(employee.getEmpId()==employeeId) {
				iterator.remove();
			}
		}
		
		if(totalSize > employees.size())
			return employees;
		else
			return null;
	}

	@Override
	public List<Employee> createEmployee(Employee employee) {
		employees.add(employee);
		return employees;
	}

	
	
	
	
	
}
