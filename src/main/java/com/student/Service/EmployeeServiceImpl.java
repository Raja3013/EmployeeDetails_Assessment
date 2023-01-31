package com.student.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Entity.Employee;
import com.student.Entity.EmployeeTaxDetails;
import com.student.Repository.EmployeeRepository;
import com.student.Repository.EmployeeTaxRepository;
import com.student.dto.TaxDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private EmployeeTaxRepository taxRepo;
	
	private TaxDto taxDto=new TaxDto();

	@Override
	public Employee createEmployee(Employee employee) {

		return employeeRepo.save(employee);
	}

	@Override
	public TaxDto findTaxOfEmployee(Long employeeId) {
		Optional<Employee> findById = employeeRepo.findById(employeeId);
		
		if (findById.isPresent()) {
			EmployeeTaxDetails empTaxDetails = new EmployeeTaxDetails();

			Employee employee = findById.get();
//			BeanUtils.copyProperties(empTaxDetails, employee);
			empTaxDetails.setEmployeeId(employee.getEmployeeID());
			
			LocalDate d = LocalDate.now();
			int months = Period.between(employee.getDoj(),d).getMonths();
			empTaxDetails.setYearlySalary(months*employee.getSalary());
			double yearlySalary = empTaxDetails.getYearlySalary();
			if (yearlySalary <= 250000) {
				empTaxDetails.setTaxAmont((yearlySalary*1.0)-yearlySalary);
			}
			if (yearlySalary >= 250000 && yearlySalary <= 500000) {
				empTaxDetails.setTaxAmont((yearlySalary*1.05)-yearlySalary);
			}
			if (yearlySalary >= 500000 && yearlySalary <= 1000000) {
				empTaxDetails.setTaxAmont((yearlySalary*1.10)-yearlySalary);
			}
			if (yearlySalary > 1000000) {
				empTaxDetails.setTaxAmont((yearlySalary*1.20)-yearlySalary);
			}
			
			 //BeanUtils.copyProperties(taxDto, empTaxDetails);
			
			taxDto.setEmployeeId(empTaxDetails.getEmployeeId());
			taxDto.setFirstName(employee.getFirstName());
			taxDto.setLastName(employee.getLastName());
			taxDto.setYearlySalary(empTaxDetails.getYearlySalary());
			taxDto.setTaxAmont(empTaxDetails.getTaxAmont());
			 taxRepo.save(empTaxDetails);
			 return taxDto;
		}else {
			throw new RuntimeException("Invalid Employee ID");
		}
		
		
	}
}
