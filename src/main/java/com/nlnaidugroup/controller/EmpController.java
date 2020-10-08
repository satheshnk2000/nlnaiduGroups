package com.nlnaidugroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nlnaidugroup.EmployeeVO;
import com.nlnaidugroup.model.Employee;
import com.nlnaidugroup.service.EmpService;
//import com.nlnaidugroup.vo.EmployeeVO;

@RestController
public class EmpController {

	@Autowired
	EmpService empService;

	@RequestMapping("/emp/getAll")
	public List<EmployeeVO> getEmpDetails() {
		return empService.getEmpDetails();
	}

	@RequestMapping(value = "/searchEmp", method = RequestMethod.POST)
	public List<EmployeeVO> search(@RequestBody EmployeeVO emp) {
		return empService.search(emp);
	}

	@RequestMapping(value = "/viewEmp/{empId}", method = RequestMethod.GET)
	public EmployeeVO viewEmp(@PathVariable String empId) {
		return empService.viewEmp(empId);
	}

//	@PutMapping("/editEmp")
//	public void editEmp(@RequestBody EmployeeVO emp) {
//		 //empService.editEmp(emp);
//		empService.
//	}
	
	@PostMapping("/newEmp")
	public void addEmp(@RequestBody EmployeeVO emp)
	{
		empService.addEmp(emp);
	}
}