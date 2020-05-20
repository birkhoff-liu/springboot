package com.birkhoff.boot.controller;

import com.birkhoff.boot.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public Article hello(){

        Article article = Article.builder().id(2L).author("莫言").build();

        log.info(article.toString());
        return  article;
    }
}
