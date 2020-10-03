package com.nlnaidugroup.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlnaidugroup.EmployeeVO;
import com.nlnaidugroup.dao.DeptRepository;
import com.nlnaidugroup.dao.EmployeeRepository;
import com.nlnaidugroup.model.Department;
import com.nlnaidugroup.model.Employee;

@Service
public class EmpService {

	@Autowired
	EmployeeRepository empDao;
	@Autowired
	DeptRepository deptDao;

	public List<EmployeeVO> getEmpDetails() {

		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		List<Employee> emps = empDao.findAll();
		for (Employee emp : emps) {
System.out.println("Hello------+"+emp.getEmpName());
			EmployeeVO empVo = getEmpVO(emp);
			empList.add(empVo);
		}
		return empList;
	}

	public List<EmployeeVO> search(EmployeeVO empVO) {

		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		// Employee emp = null;
		if (empVO.getEmpId() != null) {

			empList.add(getEmpVO(empDao.findById(empVO.getEmpId()).get()));
		} else if (empVO.getEmpName() != null) {
			List<Employee> emps = empDao.getByempName(empVO.getEmpName());
			for (Employee emp : emps)
				empList.add(getEmpVO(emp));
		}
		return empList;
	}

	private Department getDepartment(String deptNo) {
		Department dept = null;
		if (deptNo != null && !deptNo.equalsIgnoreCase(""))
			dept = deptDao.findById(Long.parseLong(deptNo)).get();
		return dept;
	}

	public EmployeeVO viewEmp(String empId) {

		return getEmpVO(empDao.findById(Long.parseLong(empId)).get());
	}

	private EmployeeVO getEmpVO(Employee emp) {
		EmployeeVO empVo = new EmployeeVO();
		empVo.setEmpId(emp.getEmpId());
		empVo.setEmpName(emp.getEmpName());
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy/MM/dd");
		empVo.setDeptNo(emp.getDeptNo());
		empVo.setSalary(emp.getSalary());
		Department dept = getDepartment(emp.getDeptNo());
		empVo.setDeptName(dept != null ? dept.getDeptName() : "");
		return empVo;
	}

	// public void editEmp(EmployeeVO emp) {
	// empDao.editEmp(getEmp(emp));
	// // return getEmpVO(emp);
	// }

	private Employee getEmp(EmployeeVO empVo) {
		Employee emp = new Employee();
		emp.setEmpId(empVo.getEmpId());
		emp.setEmpName(empVo.getEmpName());
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		emp.setDeptNo(empVo.getDeptNo());
		emp.setSalary(empVo.getSalary());
		return emp;
	}

	public void addEmp(EmployeeVO emp) {
		Employee employee = new Employee();
		employee.setEmpId(emp.getEmpId());
		employee.setEmpName(emp.getEmpName());
		employee.setDeptNo(emp.getDeptNo());
		employee.setSalary(emp.getSalary());
		empDao.save(employee);
	}

}
