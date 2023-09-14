package controller;

import model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    private final QuestionService questionService;

@GetMapping("/add")
public Question add(@RequestParam String question,@RequestParam String answer) {
    return questionService.add(question, answer);
}
@GetMapping("/remove")
public Question remove(@RequestParam String question,@RequestParam String answer) {
    return questionService.remove(new Question(question,answer));}
@GetMapping
public Collection<Question> getAll() {
    return questionService.getAll();
    }

}
