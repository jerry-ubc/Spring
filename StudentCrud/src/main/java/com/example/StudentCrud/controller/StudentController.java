package com.example.StudentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.service.StudentService;

@Controller
public class StudentController {
@Autowired
    private StudentService service;
 
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Student> liststudent = service.listAll();
        model.addAttribute("liststudent", liststudent);
        System.out.print("Get / ");
        return "index";		//html location
    }
 
    @GetMapping("/new")
    public String add(Model model) {
    	System.out.println("creating new");
        model.addAttribute("student", new Student());
        return "new";		//html location
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student std) {
    	System.out.println("Created new");
        service.insert(std);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std) {
    	System.out.println("Edited entry");
        service.update(std);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")			//Enter here when you press "Edit"
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        Student std = service.get(id);
        mav.addObject("student", std);
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}