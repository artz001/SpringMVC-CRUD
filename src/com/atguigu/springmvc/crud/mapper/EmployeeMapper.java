package com.atguigu.springmvc.crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.atguigu.springmvc.crud.entities.Employee;

public interface EmployeeMapper {
	@Select("select e.id,e.last_name,e.email,e.gender,d.department_name as \"department.departmentName\""
			+" FROM employees e"
			+" LEFT OUTER JOIN departments d"
			+" ON e.department_id = d.id"
			)
	List<Employee> getAll();
	
	@Delete("DELETE FROM employees WHERE id = #{id}")
	void delete(Integer id);
	
	@Insert("INSERT INTO employees( last_name, email, gender,department_id) VALUES(#{lastName}, #{email}, #{gender},#{department.id})")
	void save(Employee employee);
	
	@Select("SELECT e.id,e.last_name,e.email,e.gender,e.department_id as \"department.id\" ,d.department_name as \"department.departmentName\""
			+ " FROM employees e"
			+ " LEFT OUTER JOIN departments d"
			+ " ON e.department_id = d.id"
			+ " WHERE e.id = #{id}")
	
	Employee get(Integer id);
	
	@Update("UPDATE employees SET email = #{email},gender = #{gender},department_id = #{department.id} WHERE id = #{id}")
	void update(Employee employee);

}
