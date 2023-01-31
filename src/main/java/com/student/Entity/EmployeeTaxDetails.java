package com.student.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class EmployeeTaxDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taxId;
	
	@OneToOne
	private Employee employee;
	
	private Long employeeId;
	
	private double yearlySalary;
	
	private double taxAmont;
	

}
