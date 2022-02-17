package com.library.springlibrary.dao.impl;

import com.library.springlibrary.dao.AuthorDAO;
import com.library.springlibrary.domain.Author;
import com.library.springlibrary.spring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class AuthorService implements AuthorDAO {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author get(long id) {

        Optional<Author> bookMark = authorRepository.findById(id);
        if (bookMark.isPresent()) {
            return bookMark.get();
        } else {
            return null;
        }
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author object) {
        authorRepository.delete(object);
    }

    @Override
    public List<Author> search(String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0]);
    }

    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0], PageRequest.of(pageNumber, pageSize,Sort.by(sortDirection, sortField)));
    }
}
