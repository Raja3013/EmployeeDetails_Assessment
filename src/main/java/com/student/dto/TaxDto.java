package com.student.dto;

import lombok.Data;

@Data
public class TaxDto {
	
	private Long employeeId;
	private String firstName;
	private String lastName;

	private double yearlySalary;

	private double taxAmont;

}
