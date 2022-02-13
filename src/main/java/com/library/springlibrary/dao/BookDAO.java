package com.library.springlibrary.dao;

import com.library.springlibrary.domain.Book;

import java.util.List;

public interface BookDAO extends GeneralDAO<Book> {
    List<String> findTopBooks(int limit);
}
