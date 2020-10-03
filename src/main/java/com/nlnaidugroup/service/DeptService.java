package com.nlnaidugroup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlnaidugroup.dao.DeptDao;
import com.nlnaidugroup.dao.DeptRepository;
import com.nlnaidugroup.model.Department;

@Service
public class DeptService {
	
	@Autowired DeptRepository deptRepo;

	public List<Department> getDeptList() {
		return deptRepo.findAll();
	}
	
	@Transactional
	public void createDepartment(Department dept)
	{
		System.out.println("hello----deptname-----"+dept.getDeptName());
		System.out.println("hello----location-----"+dept.getLocation());
		deptRepo.save(dept);
	}
	
	public Department getDepartmentDetails(Long deptNo)
	{
		return deptRepo.getOne(deptNo);
	}
}
