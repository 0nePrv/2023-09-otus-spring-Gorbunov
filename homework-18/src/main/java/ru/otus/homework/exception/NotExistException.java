package ru.otus.homework.exception;

public class NotExistException extends RuntimeException {

  public NotExistException(String message) {
    super(message);
  }

  public NotExistException(Throwable cause) {
    super(cause);
  }
}
