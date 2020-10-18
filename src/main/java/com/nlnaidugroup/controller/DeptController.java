package com.nlnaidugroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nlnaidugroup.model.Department;
import com.nlnaidugroup.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	DeptService deptService;

	@GetMapping("/depts")
	public List<Department> greeting() {
		return deptService.getDeptList();
	}

	@PostMapping("/dept/create")
	public void createDepartment(@RequestBody Department dept) {
		deptService.createDepartment(dept);
	}
	
	@RequestMapping(value = "/viewDepartment/{deptId}", method = RequestMethod.GET)
	public Department getDepartment(@PathVariable String deptId) {
		return deptService.getDepartmentDetails(Long.parseLong(deptId));
	}
}