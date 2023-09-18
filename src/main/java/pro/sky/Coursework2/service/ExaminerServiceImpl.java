package pro.sky.Coursework2.service;

import pro.sky.Coursework2.exeption.AmountMoreThanRequiredException;
import pro.sky.Coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        Collection<Question> allQQuestion = service.getAll();
        if (service.getAll().size() < amount) {
            throw new AmountMoreThanRequiredException();
        }
        if (allQQuestion.size() == amount){
            return allQQuestion;
        }
        Set<Question> exam = new HashSet<>(amount);
        while (exam.size() != amount) {
            exam.add(service.getRandomQuestion());

        }
        return exam;
    }
}
