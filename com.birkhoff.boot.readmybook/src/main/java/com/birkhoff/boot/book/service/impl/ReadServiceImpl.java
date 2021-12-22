package com.birkhoff.boot.book.service.impl;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.birkhoff.boot.book.entity.Book;
import com.birkhoff.boot.book.mapper.BookMapper;
import com.birkhoff.boot.book.service.ReadService;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ReadServiceImpl implements ReadService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void read(String path) throws IOException {
        File file = new File(path);

        if(file.isDirectory()){

            File[] subFiles = file.listFiles();

            Arrays.stream(subFiles)
                    .filter(e -> !e.getName().equals(".DS_Store"))
                    .forEach(e -> {

                        if(e.isDirectory()){//如果还是文件夹，则进行递归调用

                            try {

                                read(e.getPath());

                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } else {
                            log.info("start insert fill ...." + e.getName());
                            Book book = new Book();
                            book.setBookName(e.getName());
                            create(book);
                        }
            });
        }

    }

    /**
     * 获取数据库中全部书名列表
     * @return
     */
    public List<Book> getDatas(Book book){

        QueryWrapper<Book> condition = new QueryWrapper<>();
        condition.lambda()
                .eq(!ObjectUtils.isEmpty(book.getBookName()),Book :: getBookName, book.getBookName());

       return bookMapper.selectList(condition);
    }

    @Transactional
    public void create(Book book){
        QueryWrapper<Book> condition = new QueryWrapper<>();
        condition.lambda()
                .eq(Book :: getBookName,book.getBookName());

        Optional<Book> has = bookMapper.selectList(condition).stream().findAny();

        if(!has.isPresent()){
            bookMapper.insert(book);
        }

    }
}
