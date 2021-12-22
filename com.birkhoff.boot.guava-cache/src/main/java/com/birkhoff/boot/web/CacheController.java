package com.birkhoff.boot.web;

import com.birkhoff.boot.book.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private CacheService cacheService;

    /**
     * 查询方法
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getByCache() {
        Long startTime = System.currentTimeMillis();
        long timestamp = this.cacheService.getByCache();
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
        return timestamp + "ms";
    }

    /**
     * 保存方法
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save() {
        this.cacheService.save();
    }

    /**
     * 删除方法
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void delete() {
        this.cacheService.delete();
    }
}
