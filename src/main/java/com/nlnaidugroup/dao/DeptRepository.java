package com.nlnaidugroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlnaidugroup.model.Department;

public interface DeptRepository extends JpaRepository<Department, Long> {
	
	

}
