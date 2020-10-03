package com.nlnaidugroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nlnaidugroup.EmployeeVO;
import com.nlnaidugroup.model.Employee;

@Repository
public class EmpDao extends JpaDAO<Employee> {

	public EmpDao() {
		setClazz(Employee.class);
	}

	public List<Employee> search(Employee emp) {

		StringBuilder hqlQuery = new StringBuilder();
		hqlQuery.append("select a from Employee a ");
		List<Employee> empList = null;
		if (emp != null) {
			if (emp.getEmpId() != null && emp.getEmpId() != 0L) {
				empList = new ArrayList<Employee>();
				empList.add(findOne(emp.getEmpId()));
				return empList;
			} else {
				if (emp.getEmpName() != null && !emp.getEmpName().equalsIgnoreCase("")) {
					if (hqlQuery.toString().indexOf("where") != -1) {
						hqlQuery.append(" and ");
					} else
						hqlQuery.append(" where ");
					hqlQuery.append(" a.empName like '").append(emp.getEmpName()).append("'");
				}
				if (emp.getSalary() != null && !(emp.getSalary() != 0L)) {
					if (hqlQuery.toString().indexOf("where") != -1) {
						hqlQuery.append(" and ");
					} else
						hqlQuery.append(" where ");
					hqlQuery.append(" a.salary =").append(emp.getSalary());
				}
				// System.out.println("hello-------" + hqlQuery.toString());
				empList = super.search(hqlQuery.toString());
			}
		}
		return empList;
	}

	public Employee viewEmp(String empId) {

		Employee emp = null;
		if (empId != null && !empId.equalsIgnoreCase(""))

			emp = findOne(Long.parseLong(empId));
		return emp;
	}

	@Transactional
	public Employee editEmp(Employee emp) {
		if (emp.getEmpId() == null) {
			return null;
		} else {
			Employee emp1 = findOne(emp.getEmpId());
			if (emp1 != null) {
				emp1 = updateEmpDetails(emp, emp1);
				update(emp);
			}
		}

		return emp;
	}

	private Employee updateEmpDetails(Employee emp, Employee empUpdated) {
		if (emp.getDeptNo() != null)
			empUpdated.setDeptNo(emp.getDeptNo());
		if (emp.getEmpName() != null)
			empUpdated.setEmpName(emp.getEmpName());
		if (emp.getSalary() != null && emp.getSalary() != 0L)
			empUpdated.setSalary(emp.getSalary());
		/*if (emp.getDateOfBirth() != null)
			empUpdated.setDateOfBirth(emp.getDateOfBirth());
		if (emp.getDateOfJoin() != null)
			empUpdated.setDateOfJoin(emp.getDateOfJoin());
		*/
		return empUpdated;
	}
	
	@Transactional
	public void addEmp(EmployeeVO emp) {
		
			Employee emp1 = new Employee();
			emp1.setDeptNo(emp.getDeptNo());
			emp1.setEmpName(emp.getEmpName());
			emp1.setSalary(emp.getSalary());
			create(emp1);
	}
}