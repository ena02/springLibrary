package com.library.springlibrary.spring.repository;

import com.library.springlibrary.domain.Book;
import com.library.springlibrary.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findAllByNameContainingIgnoreCaseOrderByName(String name);
}
