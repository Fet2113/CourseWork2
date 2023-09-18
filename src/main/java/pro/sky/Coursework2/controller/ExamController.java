package pro.sky.Coursework2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.Coursework2.model.Question;


import pro.sky.Coursework2.service.ExaminerService;
import pro.sky.Coursework2.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService service;


    public ExamController(ExaminerService service) {

        this.service = service;
    }

    @GetMapping()
    public Collection<Question> getQuestion(@PathVariable int amount) {
        return service.getQuestion(amount);
    }
}
