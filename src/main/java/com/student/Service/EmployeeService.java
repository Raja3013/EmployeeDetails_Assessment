package com.student.Service;

import com.student.Entity.Employee;
import com.student.dto.TaxDto;

public interface EmployeeService {
	
	 Employee createEmployee(Employee employee);
	 
	 TaxDto findTaxOfEmployee(Long employeeId);

}
