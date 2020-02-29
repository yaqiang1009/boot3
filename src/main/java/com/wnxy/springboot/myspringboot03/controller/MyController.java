package com.wnxy.springboot.myspringboot03.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wnxy.springboot.myspringboot03.entity.ScClass;
import com.wnxy.springboot.myspringboot03.entity.Student;

import lombok.Setter;

@Controller
public class MyController {
	@Resource
	@Setter private ApplicationContext ac;
	
	//@ResponseBody
	@RequestMapping("/mycont1")
	public String mycont1(HttpServletRequest request) {
		
		return "forward:/a.html";
	}
	//@ResponseBody
	@RequestMapping("/mycont2")
	public String mycont2(Model model) {
		model.addAttribute("a","aaa");
		model.addAttribute("hello","<h1>hello</h1>");
		model.addAttribute("users",Arrays.asList("a1","a2","a3"));
		return "/a.html";
	}
	@RequestMapping("/login")
	public String index(HttpServletRequest request,Model model,HttpSession session) {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println(0);
		if("a".equals(user)&&"aaa".equals(password)) {
			session.setAttribute("user", user);
			return "redirect:/stu";
		} /*
			 * model.addAttribute("a","aaa"); model.addAttribute("hello","<h1>hello</h1>");
			 * model.addAttribute("users",Arrays.asList("a1","a2","a3"));
			 */
		return "/login.html";
	}
	//查询所有学生
	@GetMapping("stu")
	public String selectStudent(Model mode) {
		//获取数据库信息
		List<Student> stus=new ArrayList<Student>();
		/*
		 * stus.add(new Student("st1", "张三1", "男", new ScClass("sc1", "一班")));
		 * stus.add(new Student("st2", "张三2", "男", new ScClass("sc1", "一班")));
		 * stus.add(new Student("st3", "张三3", "男", new ScClass("sc2", "二班")));
		 * stus.add(new Student("st4", "张三4", "男", new ScClass("sc2", "二班")));
		 */
		mode.addAttribute("stus",stus);
		//转到展示页面
		return "index";
	}
	//检索班级信息
	@GetMapping("scclass")
	public String selectScClass(Model mode) {
		//数据库检索
		List<ScClass> scs=new ArrayList<ScClass>();
		scs.add(new ScClass("sc1", "班级一"));
		scs.add(new ScClass("sc2", "班级二"));
		mode.addAttribute("scs",scs);
		//转到添加学生界面
		return "addstu";
	}
	//添加学生
	@PostMapping("stu")
	public String addStudent(Student stu) {
		//数据库添加
		System.out.println(stu);
		//重新检索信息
		return "redirect:/stu";
	}
	//查询单个学生用来修改
	@GetMapping("/sestu/{sid}")
	public String seStudent(@PathVariable("sid") String sid,Model mode) {
		//数据库查询学生
		System.out.println(sid);
		/*
		 * mode.addAttribute("student",new Student("st2", "张三2", "男", new ScClass("sc1",
		 * "一班")));
		 */		//数据库检索班级
		List<ScClass> scs=new ArrayList<ScClass>();
		scs.add(new ScClass("sc1", "班级一"));
		scs.add(new ScClass("sc2", "班级二"));
		mode.addAttribute("scs",scs);
		//转到更新页面
		return "upstu";
	}
	//修改学生
	@PutMapping("stu")
	public String upStudent(Student stu) {
		//数据库修改
		System.out.println(stu);
		//重新检索信息
		return "redirect:/stu";
	}
	//删除学生
	@DeleteMapping("/stu/{sid}")
	public String delStudent(@PathVariable("sid") String sid) {
		//数据库修改
		System.out.println(sid);
		//重新检索信息
		return "redirect:/stu";
	}
}
