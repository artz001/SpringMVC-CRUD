package com.atguigu.springmvc.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.mapper.DepartmentMapper;

@Service
@Transactional
public class DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getDepartments() {
		return departmentMapper.getDepartments();
	}
	
}
