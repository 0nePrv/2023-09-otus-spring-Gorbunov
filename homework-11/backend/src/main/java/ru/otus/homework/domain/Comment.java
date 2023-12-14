package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Field.Write;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {

  @Id
  private String id;

  @Field(name = "text", write = Write.NON_NULL)
  private String text;

  @Field(name = "bookId", write = Write.NON_NULL)
  private String bookId;

  public Comment(String text, String bookId) {
    this.text = text;
    this.bookId = bookId;
  }
}
