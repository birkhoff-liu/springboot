package com.birkhoff.boot.book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("sys_book")
public class Book {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String bookName;

    private Integer status;

    private String memo;

    private Timestamp createDate;
}
