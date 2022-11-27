package com.yemensoft.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yemensoft.mapper.EmployeeMapper;
import com.yemensoft.model.Employee;

public class EmployeeController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// this is the controller 
			InputStream in=Resources.getResourceAsStream("Mybatis-config.xml");
			SqlSessionFactory sql=new SqlSessionFactoryBuilder().build(in);
			SqlSession session= sql.openSession();
			System.out.println(session);
			EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
			List<Employee> list=mapper.getAllEmployee();
			
			System.out.println("empno"+"\t"+"empname"+"\t"+"hiredata"+"\t"+"sal"+"\t"+"deptno");
			System.out.println(" ====     ====      =======    ======  =====  ");
			
			for(Employee e:list){
				System.out.println(e.getEmpno() + "\t" + e.getName()+"\t"+e.getHiredate()+ "\t"+e.getSal()+"\t"+e.getDeptno()  );
			}
			
			
			System.out.println(session);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
