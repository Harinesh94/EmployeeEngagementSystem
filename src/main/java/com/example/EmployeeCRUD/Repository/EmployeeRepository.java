package com.example.EmployeeCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeCRUD.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
