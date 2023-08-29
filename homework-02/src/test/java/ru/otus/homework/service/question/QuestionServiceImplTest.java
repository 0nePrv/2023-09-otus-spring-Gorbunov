package ru.otus.homework.service.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.otus.homework.dao.QuestionDao;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Question;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class QuestionServiceImplTest {

    QuestionDao questionDao;

    QuestionService questionService;

    List<Question> questions;

    @BeforeEach
    void setUp() {
        questionDao = Mockito.mock(QuestionDao.class);
        questionService = new QuestionServiceImpl(questionDao);
        questions = List.of(
                new Question("Question1", Collections.singletonList(new Answer("1", true))),
                new Question("Question2", Collections.singletonList(new Answer("2", true))),
                new Question("Question3", Collections.singletonList(new Answer("3", true)))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    public void should_return_correct_question_by_index(int index) {
        when(questionDao.readAllQuestions()).thenReturn(questions);

        assertEquals(questionService.getQuestion(index), questions.get(index));
    }


    @Test
    public void should_return_correct_questions_quantity() {
        when(questionDao.readAllQuestions()).thenReturn(questions);

        assertEquals(questionService.getQuantity(), questions.size());
    }

}