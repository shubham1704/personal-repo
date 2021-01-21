package com.example.sampleExample.repository;

import com.example.sampleExample.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
