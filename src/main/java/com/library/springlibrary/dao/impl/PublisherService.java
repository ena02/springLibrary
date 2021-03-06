package com.library.springlibrary.dao.impl;

import com.library.springlibrary.dao.PublisherDAO;
import com.library.springlibrary.domain.Publisher;
import com.library.springlibrary.spring.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class PublisherService implements PublisherDAO {

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }



    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher){
        publisherRepository.delete(publisher);
    }


    @Override
    public Publisher get(long id) {
        Optional<Publisher> bookmark = publisherRepository.findById(id); // Optional - обертка, в котором может быть значение или пусто (используется для исключение ошибки NullPointerException
        if (bookmark.isPresent()) { // если значение представлено - вернуть его
            return bookmark.get();
        } else {
            return null;
        }
    }

}
