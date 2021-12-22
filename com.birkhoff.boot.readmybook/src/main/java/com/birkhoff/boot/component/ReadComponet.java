package com.birkhoff.boot.component;

import com.birkhoff.boot.book.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class ReadComponet {

    @Autowired
    private ReadService readService;

    private final String PATH = "/Users/birkhoffliu/dev/阅读";

    @PostConstruct
    public void operator() throws IOException {
        readService.read(PATH);
    }


}
