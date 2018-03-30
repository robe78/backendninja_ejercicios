package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSES_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
// UTLIZANDO LA ENTIDAD	(Course)
/*	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW );
		mav.addObject("course", new Course());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute ("course") Course course){
		LOG.info("Call: " + "addCourse()" + " -- Param: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listcourses";
	}*/
	

//  UTILIZANDO EL MODELO (CourseModel)
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;	
	
	//LISTAR
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new Course());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}
	
	//AÑADIR
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute ("course") CourseModel courseModel){
		LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
		courseService.addCourse(courseConverter.model2entity(courseModel));
		return "redirect:/courses/listcourses";
	}
	
	//BORRAR
	@PostMapping("/deletecourse")
	public String deleteCourse(@ModelAttribute ("course") Course course){
		LOG.info("Call: " + "deleteCourse()" + " -- Param: " + course.toString());
		courseService.removeCourse(course.getId());
		LOG.info("Call: " + "getId()" + " -- Param: " + course.getId());
		return "redirect:/courses/listcourses";
	}
	
	//MODIFICAR
	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute ("course") Course course){
		LOG.info("Call: " + "updateCourse()" + " -- Param: " + course.toString());
		courseService.updateCourse(course);
		return "redirect:/courses/listcourses";
	}
}
