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
		return (List<Department>) departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		Department depDB = departmentRepository.findById(departmentId).get();

		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}

		if (Objects.nonNull(department.getDepartmentAdd()) && !"".equalsIgnoreCase(department.getDepartmentAdd())) {
			depDB.setDepartmentAdd(department.getDepartmentAdd());
		}

		if (Objects.nonNull(department.getDpartmentCode()) && !"".equalsIgnoreCase(department.getDpartmentCode())) {
			depDB.setDpartmentCode(department.getDpartmentCode());
		}

		return departmentRepository.save(depDB);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);

	}

}