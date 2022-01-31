package com.example.EmployeeCRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeCRUD.Model.Employee;
import com.example.EmployeeCRUD.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository empRep;

	public List<Employee> getAllEmployees(){
		return empRep.findAll();
	}
	
	public void saveEmployee(Employee emp) {
		empRep.save(emp);
	}
	
	public Employee getEmpbyId(long id) {
		Optional<Employee> emp = empRep.findById(id);
		Employee employee = null;
		if(emp.isPresent()) {
			employee = emp.get();
		}else {
			throw new  RuntimeException("Employee not Found"+id);
		}
		return employee;
	}
	
	public void deleteByEmpId(long id) {
		empRep.deleteById(id);
	}
}
