package pro.sky.Coursework2.service;

import pro.sky.Coursework2.exeption.QuestionAlredyExeption;
import pro.sky.Coursework2.exeption.QuestionNotFoundExeption;
import pro.sky.Coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        for (Question q : questions) {
            if (q.equals(question)) {
                throw new QuestionAlredyExeption();
            }
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionNotFoundExeption();
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>();
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new QuestionNotFoundExeption();
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
