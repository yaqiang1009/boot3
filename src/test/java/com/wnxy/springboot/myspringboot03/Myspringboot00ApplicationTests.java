package com.wnxy.springboot.myspringboot03;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.springboot.myspringboot03.entity.Student;
import com.wnxy.springboot.myspringboot03.mapper.StudentMapper;
import com.wnxy.springboot.myspringboot03.service.StuService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Myspringboot00ApplicationTests {
	@Autowired
	ApplicationContext ac;

	@Autowired 
	StudentMapper studentMapper;
	@Autowired
	StuService stuService;
	@Test
	public void contextLoads() {
		//stuService.addStu();
		
		  Student stu=new Student("s037", "a", 20, "女"); studentMapper.addstudent(stu);
		  System.out.println("添加完成");
		 
	}

}
