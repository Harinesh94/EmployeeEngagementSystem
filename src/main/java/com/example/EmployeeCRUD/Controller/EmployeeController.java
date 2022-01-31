package com.example.EmployeeCRUD.Controller;

import java.net.http.HttpClient.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.EmployeeCRUD.Model.Employee;
import com.example.EmployeeCRUD.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listofEmployees", empService.getAllEmployees());
		return "index";
		
	}
	
	@GetMapping("/createEmployees")
	public String employeeCreation() {
		return "createEmployee";
	}
	
	@PostMapping("/saveEmployees")
	public String saveEmployees(@ModelAttribute Employee employee,Model model) {
		empService.saveEmployee(employee);
		model.addAttribute("listofEmployees", empService.getAllEmployees());
		return "index"; 	
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String updateEmployees(@PathVariable(value ="id") long id,Model model) {
		Employee emp = empService.getEmpbyId(id);
		model.addAttribute("employees", emp);
		
		return "updateEmp";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmpId(@PathVariable(value="id") long id) {
		empService.deleteByEmpId(id);
		return "redirect:/";
	}
}
