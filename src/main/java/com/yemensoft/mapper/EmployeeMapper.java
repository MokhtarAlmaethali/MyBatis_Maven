package com.yemensoft.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yemensoft.model.Employee;

public interface EmployeeMapper {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByID(int empno);
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getEmployeeByCandition1(@Param("name") String name , @Param("hiredate") Date hiredate);
	public List<Employee> getEmployeeByCandition2(Employee emp);
	
	public List<Employee> getEmployeeByHashMap();

}
