package ru.otus.homework.repository.custom;

import ru.otus.homework.domain.Author;

public interface AuthorRepositoryCustom {

  Author updateWithBooks(Author author);
}
