package com.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
