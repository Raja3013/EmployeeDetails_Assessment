package com.student.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.Entity.EmployeeTaxDetails;

public interface EmployeeTaxRepository extends JpaRepository<EmployeeTaxDetails, Serializable> {

}
