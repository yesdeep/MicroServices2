package com.tech.model;

public class Employee {

	private String empId;
	private String empName;
	private String healthInsuranceSchemeName;
	private int coverageAmount;
	
	
	public String getHealthInsuranceSchemeName() {
		return healthInsuranceSchemeName;
	}
	public void setHealthInsuranceSchemeName(String healthInsuranceSchemeName) {
		this.healthInsuranceSchemeName = healthInsuranceSchemeName;
	}
	public int getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(int coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

}