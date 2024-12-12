package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	private String departmentName;
	private String departmentAdd;
	private String dpartmentCode;
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentAdd() {
		return departmentAdd;
	}
	public void setDepartmentAdd(String departmentAdd) {
		this.departmentAdd = departmentAdd;
	}
	public String getDpartmentCode() {
		return dpartmentCode;
	}
	public void setDpartmentCode(String dpartmentCode) {
		this.dpartmentCode = dpartmentCode;
	}
	
	
}
