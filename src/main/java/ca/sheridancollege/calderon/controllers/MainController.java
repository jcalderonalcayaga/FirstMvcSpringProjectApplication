package ca.sheridancollege.calderon.controllers;

import ca.sheridancollege.calderon.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class MainController {

    List<Student> students = new CopyOnWriteArrayList<Student>();

    @RequestMapping("/")
    public String returnInput(Model model){
        Student student = new Student();
        model.addAttribute(student);
        return "input";
    }

    @RequestMapping("/processInput")
    public String process(Model model, @ModelAttribute Student student){
        //Student student = new Student(id, fullName);
        //student.setId(id);
        //student.setName(fullName);
        students.add(student);
        model.addAttribute("myStudent", students);
        return "output";


    }
}
