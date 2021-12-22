package com.birkhoff.boot.book.service;

import com.birkhoff.boot.book.entity.Book;

import java.io.IOException;
import java.util.List;

public interface ReadService {

     void read(String path) throws IOException;

     /**
      * 获取数据库中全部书名列表
      * @return
      */
     public List<Book> getDatas(Book book);

}
