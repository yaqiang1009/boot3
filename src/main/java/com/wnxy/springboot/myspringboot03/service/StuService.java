package com.wnxy.springboot.myspringboot03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wnxy.springboot.myspringboot03.entity.Student;
import com.wnxy.springboot.myspringboot03.mapper.StudentMapper;
@Service
public class StuService {
	@Autowired 
	StudentMapper studentMapper;
	
	@Transactional
	public void addStu() {
		studentMapper.addstudent(new Student("s036", "a", 20, "女"));
		if(true) {
			throw new RuntimeException();
		}
		studentMapper.addstudent(new Student("s037", "a", 20, "女"));
	}
}
