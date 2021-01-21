package com.example.sampleExample.repository;

import com.example.sampleExample.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
