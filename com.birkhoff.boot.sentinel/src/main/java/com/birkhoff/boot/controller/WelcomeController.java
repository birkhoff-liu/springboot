package com.birkhoff.boot.controller;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController  {

	@SentinelResource(value = "testBlock",blockHandler  = "blockHandlerMethod")
	@GetMapping("/testBlock")
	public String testBlock(){
		return "限流方法测试，正常返回结果";
	}

	/**
	 * 限流执行方法
	 * */
	public String blockHandlerMethod(BlockException be){
		be.printStackTrace();
		return "执行限流方法，被限流啦";
	}

	@SentinelResource(value = "testFallback",fallback = "fallbackMethod")
	@GetMapping("/testFallback")
	public String testFallback(int i){
		double result=1/i;
		return "降级方法测试，正常返回结果:"+result;
	}

	/**
	 * 降级执行方法
	 * */
	public String fallbackMethod(int i){
		return "执行降级方法，错误次数太多，请稍后再试";
	}
	
}
