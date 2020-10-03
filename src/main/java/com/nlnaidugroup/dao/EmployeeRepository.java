package com.nlnaidugroup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlnaidugroup.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> getByempName(String empName);
	List<Employee> getBydeptNo(String deptNo);
}