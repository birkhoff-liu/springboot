package com.birkhoff.boot.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CacheService {
    @CachePut(value = "guavacache")
    public long save() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        System.out.println("进行缓存：" + timestamp);
        return timestamp;
    }

    @CacheEvict(value = "guavacache")
    public void delete() {
        System.out.println("删除缓存");
    }

    @Cacheable(value = "guavacache")
    public long getByCache() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Timestamp(System.currentTimeMillis()).getTime();
    }
}
