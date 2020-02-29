package com.wnxy.springboot.myspringboot03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wnxy.springboot.myspringboot03.entity.Student;

//@Mapper
public interface StudentMapper {
void addstudent(Student stu);
}
