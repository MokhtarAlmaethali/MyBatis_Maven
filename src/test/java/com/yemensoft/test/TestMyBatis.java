package com.yemensoft.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yemensoft.mapper.EmployeeMapper;
import com.yemensoft.model.Employee;

public class TestMyBatis {
	
	private Scanner sc;

	@Test
	public void GetAllEmployeeById()
	{
		try {
			InputStream in=Resources.getResourceAsStream("Mybatis-config.xml");
			SqlSessionFactory sql=new SqlSessionFactoryBuilder().build(in);
			SqlSession session= sql.openSession();
			System.out.println(session);
			EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the id of the employee");
			int empno=sc.nextInt();
			
			Employee e=mapper.getEmployeeByID(empno);
			
			System.out.println("empno"+"\t"+"empname"+"\t"+"hiredata"+"\t"+"sal"+"\t"+"deptno");
			System.out.println(" ====     ====      =======    ======  =====  ");
			System.out.println(e.getEmpno() + "\t" + e.getName()+"\t"+e.getHiredate()+ "\t"+e.getSal()+"\t"+e.getDeptno()  );
			
			
			
			System.out.println(session);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void GetAllEmployeeByName()
	{
		try {
			InputStream in=Resources.getResourceAsStream("Mybatis-config.xml");
			SqlSessionFactory sql=new SqlSessionFactoryBuilder().build(in);
			SqlSession session= sql.openSession();
			System.out.println(session);
			EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the name of the employee");
			String empname=sc.nextLine();
			
			List<Employee> list=mapper.getEmployeeByName(empname);
			
			System.out.println("empno"+"\t"+"empname"+"\t"+"hiredata"+"\t"+"sal"+"\t"+"deptno");
			System.out.println(" ====     ====      =======    ======  =====  ");
			for(Employee e: list){
			System.out.println(e.getEmpno() + "\t" + e.getName()+"\t"+e.getHiredate()+ "\t"+e.getSal()+"\t"+e.getDeptno()  );
			}
			
			
			System.out.println(session);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void GetAllEmployeeByCandition1()
	{
		try {
			InputStream in=Resources.getResourceAsStream("Mybatis-config.xml");
			SqlSessionFactory sql=new SqlSessionFactoryBuilder().build(in);
			SqlSession session= sql.openSession();
			System.out.println(session);
			EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the name of the employee");
			String empname=sc.nextLine();
			System.out.println("Enter the Hire date of the employee");
			String hiredate= sc.nextLine();
			List<Employee> list=mapper.getEmployeeByCandition1(empname, Date.valueOf(hiredate));
			
			System.out.println("empno"+"\t"+"empname"+"\t"+"hiredata"+"\t"+"sal"+"\t"+"deptno");
			System.out.println(" ====     ====      =======    ======  =====  ");
			for(Employee e: list){
			System.out.println(e.getEmpno() + "\t" + e.getName()+"\t"+e.getHiredate()+ "\t"+e.getSal()+"\t"+e.getDeptno()  );
			}
			
			
			System.out.println(session);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void GetAllEmployeeByCandition2()
	{
		//
		try {
			InputStream in=Resources.getResourceAsStream("Mybatis-config.xml");
			SqlSessionFactory sql=new SqlSessionFactoryBuilder().build(in);
			SqlSession session= sql.openSession();
			System.out.println(session);
			EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
			
			sc = new Scanner(System.in);
			System.out.println("Enter the name of the employee");
			String empname=sc.nextLine();
			System.out.println("Enter the Hire date of the employee");
			String hiredate= sc.nextLine();
			Employee emp = new Employee();
			emp.setName(empname);
			emp.setHiredate(Date.valueOf(hiredate));
			List<Employee> list=mapper.getEmployeeByCandition2(emp);
			
			System.out.println("empno"+"\t"+"empname"+"\t"+"hiredata"+"\t"+"sal"+"\t"+"deptno");
			System.out.println(" ====     ====      =======    ======  =====  ");
			for(Employee e: list){
			System.out.println(e.getEmpno() + "\t" + e.getName()+"\t"+e.getHiredate()+ "\t"+e.getSal()+"\t"+e.getDeptno()  );
			}
			
			
			System.out.println(session);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
