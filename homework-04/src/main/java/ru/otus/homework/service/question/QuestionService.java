package ru.otus.homework.service.question;

import ru.otus.homework.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestions();
}