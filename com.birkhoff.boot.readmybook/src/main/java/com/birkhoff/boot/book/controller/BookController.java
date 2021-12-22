package com.birkhoff.boot.book.controller;

import com.birkhoff.boot.book.entity.Book;
import com.birkhoff.boot.book.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private ReadService readService;

    @GetMapping
    public List<Book> get(Book book){
        return readService.getDatas(book);
    }


}
