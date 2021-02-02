package ca.sheridancollege.calderon.controllers;

import ca.sheridancollege.calderon.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class MainController {

    String programs[]={"Computer Engineer", "System Analyst", "Network Technician"};

    List<Student> students = new CopyOnWriteArrayList<Student>();

    @GetMapping("/")
    public String returnInput(Model model){
        Student student = new Student();
        model.addAttribute(student);
        model.addAttribute("programs",programs);
        return "input";
    }

    @PostMapping("/processInput")
    public ModelAndView process(Model model, @ModelAttribute Student student){
        //Student student = new Student(id, fullName);
        //student.setId(id);
        //student.setName(fullName);
        students.add(student);
        return  new ModelAndView("output","studentList",students);



    }
}
