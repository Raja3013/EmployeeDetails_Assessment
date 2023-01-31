package com.student.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Entity.Employee;
import com.student.Service.EmployeeService;
import com.student.dto.TaxDto;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.OK);
	}

	@GetMapping("/tax/{employeeID}")
	public ResponseEntity<TaxDto> findTaxUsingEmployeeId(@PathVariable("employeeID") Long employeeID) {
		return new ResponseEntity<TaxDto>(employeeService.findTaxOfEmployee(employeeID), HttpStatus.OK);
	}
}
