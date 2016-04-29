package com.atguigu.springmvc.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.springmvc.crud.entities.Employee;
import com.atguigu.springmvc.crud.mapper.EmployeeMapper;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	public List<Employee> getAll() {
		return employeeMapper.getAll();
	}

	public void delete(Integer id) {
		employeeMapper.delete(id);
	}

	public void save(Employee employee) {
		employeeMapper.save(employee);
	}

	public Employee get(Integer id) {
		return employeeMapper.get(id);
	}

	public void update(Employee employee) {
		employeeMapper.update(employee);
	}

}
