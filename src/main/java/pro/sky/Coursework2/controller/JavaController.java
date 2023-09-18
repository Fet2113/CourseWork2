package pro.sky.Coursework2.controller;
import pro.sky.Coursework2.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Coursework2.service.JavaQuestionService;
import pro.sky.Coursework2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final JavaQuestionService service;

    public JavaController(JavaQuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAll() {
        return service.getAll();
    }

}
