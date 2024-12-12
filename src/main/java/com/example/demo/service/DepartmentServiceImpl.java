package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class.getName());

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		System.out.println("Save started");
		log.info("Save started");
		return departmentRepository.save(department);

	}

	@Override
	public List<Department> fetchDepartmentList() {
		log.info("Fetch started");
		return (List<Department>) departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		log.info("Update started");
		Department dept = departmentRepository.findById(departmentId).get();

		if (Objects.nonNull(department.getDepartmentName()) && department.getDepartmentName() != null) {
			dept.setDepartmentName(department.getDepartmentName());
		}

		if (Objects.nonNull(department.getDepartmentAdd()) && department.getDepartmentAdd() != null) {
			dept.setDepartmentAdd(department.getDepartmentAdd());
		}

		if (Objects.nonNull(department.getDpartmentCode()) && department.getDpartmentCode() != null) {
			dept.setDpartmentCode(department.getDpartmentCode());
		}

		return departmentRepository.save(dept);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		log.info("Delete started");
		departmentRepository.deleteById(departmentId);

	}

}
