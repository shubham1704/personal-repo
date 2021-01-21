package com.example.sampleExample.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Slf4j
@NoArgsConstructor
@Entity
public class Book {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String isbn;

  @ManyToMany
  @JoinTable (name = "author_book", joinColumns = @JoinColumn (name = "book_id"),
      inverseJoinColumns = @JoinColumn (name = "author_id"))
  private Set<Author> authors = new HashSet<>();

  public Book(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
  }

  @Override
  public String toString() {
    return "Book{" +
           "id=" + id +
           ", title='" + title + '\'' +
           ", isbn='" + isbn + '\'' +
           ", authors=" + authors +
           '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book)o;
    return Objects.equals(id, book.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
