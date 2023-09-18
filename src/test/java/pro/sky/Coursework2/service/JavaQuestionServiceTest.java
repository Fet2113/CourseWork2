package pro.sky.Coursework2.service;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Coursework2.exeption.QuestionAlreadyAddedException;
import pro.sky.Coursework2.exeption.QuestionNotFoundExeption;
import pro.sky.Coursework2.model.Question;

class JavaQuestionServiceTest {
    JavaQuestionService service = new JavaQuestionService();


    @Test
    public void add() {
        Question expected = new Question("вопрос 4", "ответ 4");
        Question actual = service.add("вопрос 4", "ответ 4");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAdd() {
        service.add("вопрос 1", "ответ 1");
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                () -> service.add(new Question( "вопрос 1", "ответ 1")));
    }

    @Test
    void remove() {
        Assertions.assertThrows(QuestionNotFoundExeption.class,
                () -> service.remove(new Question("вопрос 4", "ответ 4")));
    }

    @Test
    void getAll() {
          Assertions.assertThrows(UnsupportedOperationException.class, () ->
                  service.getAll().add(new Question("вопрос 1","ответ 1")));

    }

    @Test
    public void getRandomQuestion() {

        Assertions.assertThrows(QuestionNotFoundExeption.class, () -> service.getRandomQuestion());
    }
}