package ru.otus.homework.controller;


import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.homework.dto.GenreDto;
import ru.otus.homework.service.GenreService;


@Controller
public class GenreController {

  private final GenreService genreService;

  @Autowired
  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @GetMapping("genre/new")
  public String create(Model model) {
    model.addAttribute("targetGenre", new GenreDto());
    return "genre/genre-add";
  }

  @PostMapping("genre/new")
  public String add(@Valid @ModelAttribute("targetGenre") GenreDto genre, Errors errors) {
    if (errors.hasErrors()) {
      return "genre/genre-add";
    }
    genreService.add(genre.getName());
    return "redirect:/genre";
  }

  @GetMapping("genre")
  public String getAll(Model model) {
    List<GenreDto> genres = genreService.getAll();
    model.addAttribute("genres", genres);
    return "genre/genre-list";
  }

  @GetMapping("genre/update/{id}")
  public String edit(@PathVariable("id") long id, Model model) {
    GenreDto genreDto = genreService.get(id);
    model.addAttribute("targetGenre", genreDto);
    return "genre/genre-edit";
  }

  @PostMapping("genre/update/{id}")
  public String update(@PathVariable("id") long id,
      @Valid @ModelAttribute("targetGenre") GenreDto genre, Errors errors) {
    if (errors.hasErrors()) {
      return "genre/genre-edit";
    }
    genreService.update(id, genre.getName());
    return "redirect:/genre";
  }

  @PostMapping("genre/delete/{id}")
  public String remove(@PathVariable("id") long id) {
    genreService.remove(id);
    return "redirect:/genre";
  }
}
