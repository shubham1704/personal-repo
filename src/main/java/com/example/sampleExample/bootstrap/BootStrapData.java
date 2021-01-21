package com.example.sampleExample.bootstrap;

import com.example.sampleExample.model.Author;
import com.example.sampleExample.model.Book;
import com.example.sampleExample.model.Publisher;
import com.example.sampleExample.repository.AuthorRepository;
import com.example.sampleExample.repository.BookRepository;
import com.example.sampleExample.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;
  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author("Eric", "Evans");
    Book book = new Book("SomeBook Very Famous", "123223");
    eric.getBooks().add(book);
    book.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(book);

    Author rod = new Author("Rod", "Johnson");
    Book j2ee = new Book("J2EE", "45656");

    rod.getBooks().add(j2ee);
    j2ee.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(j2ee);

    Publisher blackbook = new Publisher("Black Book","Navada 1st strret","NewYork","Somewhere", "221002");
    publisherRepository.save(blackbook);

    System.out.println("Started in Bootstrap");
    System.out.println("Number Of Books "+ bookRepository.count());
    System.out.println("Publisher is "+publisherRepository.count());
  }
}
