package com.wnxy.springboot.myspringboot03.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student {
private String sno;
private String sname;
private Integer sage;
private String ssex;
}
