package ru.otus.homework.repository.custom;

import ru.otus.homework.domain.Book;

public interface BookRepositoryCustom {

  Book updateWithComments(Book book);

  void deleteByIdAndCascade(String id);

  Book checkAndInsert(Book book);
}
