package com.birkhoff.boot.book.service;

import com.birkhoff.boot.pojo.User;

public interface MyBatisUserService {
    public User getUser(Long id);
}