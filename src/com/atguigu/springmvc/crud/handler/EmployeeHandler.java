package com.atguigu.springmvc.crud.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import com.atguigu.springmvc.crud.service.DepartmentService;
import com.atguigu.springmvc.crud.service.EmployeeService;

@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String list(Map<String, Object> empMap){
		System.out.println(employeeService.getAll());
		empMap.put("emps", employeeService.getAll());
		return "list";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		map.put("depts", departmentService.getDepartments());
		map.put("emp", new Employee());
		return "input";
	}
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id")Integer id){
		employeeService.delete(id);
		return "redirect:/emps";
	}
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id")Integer id ,Map<String, Object> map){
		map.put("emp", employeeService.get(id));
		System.out.println(departmentService.getDepartments());
		map.put("depts", departmentService.getDepartments());
		return "input";
	}
	@ModelAttribute
	public void model(@RequestParam(value="id",required=false)Integer id,Map<String, Object> map){
		if(id!=null){
			Employee employee = employeeService.get(id);
			map.put("employee", employee);
		}
	
	}
	@RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeService.update(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String save(Employee emp){
		employeeService.save(emp);
		return "redirect:/emps";
	}
	
}
