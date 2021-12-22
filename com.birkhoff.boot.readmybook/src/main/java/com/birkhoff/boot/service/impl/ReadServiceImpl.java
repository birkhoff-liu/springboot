package com.birkhoff.boot.service.impl;

import com.birkhoff.boot.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Service
public class ReadServiceImpl implements ReadService {

    @Autowired
    private static ResourceLoader resourceLoader;

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
                            System.out.println(e.getAbsolutePath() + File.separator + e.getName());
                        }
            });
        }


    }
}
