package com.atguigu.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	

	private static Integer initId = 1006;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
