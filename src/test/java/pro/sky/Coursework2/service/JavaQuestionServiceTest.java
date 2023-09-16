package pro.sky.Coursework2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Coursework2.exeption.QuestionAlreadyAddedException;
import pro.sky.Coursework2.exeption.QuestionNotFoundExeption;
import pro.sky.Coursework2.model.Question;

class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        javaQuestionService.add("вопрос1", "ответ1");
        javaQuestionService.add("вопрос2", "ответ2");
        javaQuestionService.add("вопрос3", "ответ3");

    }


    @Test
    void add() {
        Question expected = new Question("вопрос4", "ответ4");
        Question actual = javaQuestionService.add("вопрос4", "ответ4");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                () -> javaQuestionService.add(new Question( "вопрос1", "ответ1")));
    }

    @Test
    void remove() {
        Assertions.assertThrows(QuestionNotFoundExeption.class,
                () -> javaQuestionService.remove(new Question("вопрос4", "ответ4")));
    }

    @Test
    void getAll() {
    }

    @Test
    void getRandomQuestion() {
    }
}