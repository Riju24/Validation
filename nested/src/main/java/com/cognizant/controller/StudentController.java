package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;
import com.cognizant.validator.StudentValidator;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired 
	private StudentValidator studentValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(studentValidator);
	}
	
	
	
	
	@RequestMapping(value="/")
	public ModelAndView index() 
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public ModelAndView insert()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insert");
		Student student = new Student();
		mv.addObject("student", student);
		
		return mv;
	}
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute("student") @Validated Student student, BindingResult result, Model model)
	{
		ModelAndView mv = new ModelAndView();
		
		if (result.hasErrors()) {
			
			mv.setViewName("insert");
			return mv;//Redirecting to input page
		}
		
	
		mv.setViewName("display");
		
		
		int res = studentService.create(student);
		
		return mv;
	}
	
	
	
	@RequestMapping(value="display")
	public ModelAndView display()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		
		List<Student> li = studentService.findAll();
		mv.addObject("list",li);
		return mv;
	
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam("id") int id)
	{
		ModelAndView mv = new ModelAndView();
		
		Student s = studentService.getById(id);
		
		Student student = new Student();
		mv.addObject("student", student);
		mv.addObject("s",s);
		mv.setViewName("update");
	
		return mv;
	
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("student") @Validated Student student, BindingResult result, Model model)
	{
		ModelAndView mv = new ModelAndView();
		
		if (result.hasErrors()) {
			
			mv.setViewName("update");
			return mv;//Redirecting to update page
		}
		studentService.update(student);
	
		return display();
	
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id)
	{
		ModelAndView mv = new ModelAndView();
		
		Student s = studentService.getById(id);
		
		int r = studentService.delete(s);
	
		return display();
	
	}
	
	
	
}
