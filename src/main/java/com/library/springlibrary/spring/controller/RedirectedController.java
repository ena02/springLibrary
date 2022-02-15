package com.library.springlibrary.spring.controller;

import com.library.springlibrary.domain.Author;
import com.library.springlibrary.domain.Book;
import com.library.springlibrary.domain.Genre;
import com.library.springlibrary.domain.Publisher;
import com.library.springlibrary.spring.repository.AuthorRepository;
import com.library.springlibrary.spring.repository.BookRepository;
import com.library.springlibrary.spring.repository.GenreRepository;
import com.library.springlibrary.spring.repository.PublisherRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Log
public class RedirectedController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private PublisherRepository publisherRepository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirected(HttpServletRequest request, HttpServletResponse response, @PageableDefault(value=10, page=0, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {


        Page<Book> bookList = bookRepository.findByGenre(13, pageable);
        return "ok";
    }
}
