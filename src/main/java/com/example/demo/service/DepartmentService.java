package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.dto.Department;

public interface DepartmentService {

	Department saveDepartment(@Valid Department department);

	List<Department> fetchDepartmentList();
	 
    Department updateDepartment(Department department,Long departmentId);
 
    void deleteDepartmentById(Long departmentId);

	
}
