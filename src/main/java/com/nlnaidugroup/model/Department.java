package com.nlnaidugroup.model;


import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "DEPARTMENT")
public class Department implements Serializable{

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "DEPTNO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPT_SEQUENCE")
    @SequenceGenerator(sequenceName = "DEPT_SEQUENCE", allocationSize = 1, name = "DEPT_SEQUENCE")
    Long deptNo;

    @Column(name = "DEPTNAME")
    String deptName;

    public Long getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "LOCATION")
    String location;

}