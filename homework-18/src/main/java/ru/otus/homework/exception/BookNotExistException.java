package ru.otus.homework.exception;

public class BookNotExistException extends NotExistException {

  public BookNotExistException(String message) {
    super(message);
  }

  public BookNotExistException(Throwable cause) {
    super(cause);
  }
}
