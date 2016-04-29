package com.atguigu.springmvc.crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.atguigu.springmvc.crud.entities.Department;

public interface DepartmentMapper {
	@Select("SELECT ID,DEPARTMENT_NAME as departmentName FROM departments")
	List<Department> getDepartments();
	
}
