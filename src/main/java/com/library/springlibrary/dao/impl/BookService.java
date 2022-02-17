package com.library.springlibrary.dao.impl;

import com.library.springlibrary.dao.BookDAO;
import com.library.springlibrary.domain.Book;
import com.library.springlibrary.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class BookService implements BookDAO {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findTopBooks(int limit) {
        return null;
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContent(id);
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId) {
        return bookRepository.findByGenre(genreId, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(long id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);

        if (book.getContent()!=null) {
            bookRepository.updateContent(book.getContent(), book.getId());
        }

        return book;
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> search(String... searchString) {
        return null;
    }

    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllWithoutContent(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchString[0], searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
}
