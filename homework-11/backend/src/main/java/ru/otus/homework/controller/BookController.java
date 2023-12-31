package ru.otus.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.homework.dto.BookDto;
import ru.otus.homework.service.BookService;


@RestController
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping("api/book")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<BookDto> add(@RequestBody Mono<BookDto> bookDtoMono) {
    return bookService.add(bookDtoMono);
  }

  @GetMapping(value = "api/book")
  public Flux<BookDto> getAll() {
    return bookService.getAll();
  }

  @GetMapping("/api/book/{id}")
  public Mono<BookDto> get(@PathVariable String id) {
    return bookService.get(id);
  }

  @PutMapping("api/book/{id}")
  public Mono<BookDto> update(@PathVariable("id") String id,
      @RequestBody Mono<BookDto> bookDtoMono) {
    return bookService.update(id, bookDtoMono);
  }

  @DeleteMapping("api/book/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> remove(@PathVariable("id") String id) {
    return bookService.remove(id);
  }
}
