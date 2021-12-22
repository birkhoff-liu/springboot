package com.birkhoff.boot.controller;

import com.birkhoff.boot.intercept.MyIntercept;
import com.birkhoff.boot.pojo.User;
import com.birkhoff.boot.proxy.ProxyBean;
import com.birkhoff.boot.book.service.HelloService;
import com.birkhoff.boot.book.service.UserService;
import com.birkhoff.boot.book.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RunController {

    @Autowired
    private UserService userService = null;

    @RequestMapping(value = "/aop")
    public void aop(){
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyIntercept());
        proxy.sayHello("zhangsan");
        System.out.println("\n###############name is null!!#############\n");
        proxy.sayHello(null);
    }

    @RequestMapping(value = "/printUser")
    @ResponseBody
    public User printUser(Long id, String userName, String note){
        User user = new User();
        user.setId(id);
        user.setUsername(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }
}
