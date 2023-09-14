package service;

import model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestion(int amound) {
        if (amound < 0 || amound > questionService.getAll().size()) {
            throw new AmountMoreThanRequiredException();}
        Set<Question> exam = new HashSet<>();
        while (exam.size() < amound) {
            exam.add(questionService.getRandomQuestion());

        }
            return exam;
        }
    }
