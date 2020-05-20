package com.birkhoff.boot.config;

//静态导入
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.birkhoff.boot.handler.UserHandler;
import com.birkhoff.boot.pojo.User;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.*;


import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**** other packages import ****/
@Configuration
public class RouterConfig {
	// 注入用户处理器
	@Autowired
	private UserHandler userHandler = null;

	// 请求头用户名属性名称
	private static final String HEADER_NAME = "header_user";
	// 请求头密码属性名称
	private static final String HEADER_VALUE = "header_password";

	@Bean
	public RouterFunction<ServerResponse> securityRouter() {
		RouterFunction<ServerResponse> router = route(GET("/security/user/{id}").and(accept(APPLICATION_STREAM_JSON)),userHandler::getUser).filter((request, next) -> filterLogic(request,next));
				// 对应请求URI的对应关系
//				route(
//						// GET请求和其路径
//						GET("/security/user/{id}")
//								// 响应结果为JSON数据流
//								.and(accept(APPLICATION_STREAM_JSON)),
//						// 定义处理方法
//						userHandler::getUser)
//								// 使用过滤器
//								.filter((request, next) -> filterLogic(request, next));
		return router;
	}

	// 用户路由
	@Bean
	public RouterFunction<ServerResponse> userRouter() {
		RouterFunction<ServerResponse> router =
				// 对应请求URI的对应关系
				route(
						// GET请求和其路径
						GET("/router/user/{id}")
								// 响应结果为JSON数据流
								.and(accept(APPLICATION_STREAM_JSON)),
						// 定义处理方法
						userHandler::getUser)
								// 增加一个路由
								.andRoute(
										// GET请求和其路径
										GET("/router/user/{userName}/{note}").and(accept(APPLICATION_STREAM_JSON)),
										// 定义处理方法
										userHandler::findUsers)
								// 增加一个路由
								.andRoute(
										// POST请求和其路径
										POST("/router/user")
												// 请求体为JSON数据流
												.and(contentType(APPLICATION_STREAM_JSON)
														// 响应结果为JSON数据流
														.and(accept(APPLICATION_STREAM_JSON))),
										// 定义处理方法
										userHandler::insertUser)
								// 增加一个路由
								.andRoute(
										// PUT请求和其路径
										PUT("/router/user")
												// 请求体为JSON数据流
												.and(contentType(APPLICATION_STREAM_JSON))
												// 响应结果为JSON数据流
												.and(accept(APPLICATION_STREAM_JSON)),
										// 定义处理方法
										userHandler::updateUser)
								.andRoute(
										// DELETE请求和其路径
										DELETE("/router/user/{id}")
												// 响应结果为JSON数据流
												.and(accept(APPLICATION_STREAM_JSON)),
										// 定义处理方法
										userHandler::deleteUser)
								.andRoute(
										// PUT请求和其路径
										PUT("/router/user/name")
												// 响应结果为JSON数据流
												.and(accept(APPLICATION_STREAM_JSON)),
										// 定义处理方法
										userHandler::updateUserName);
		return router;
	}

	// 请求过滤器逻辑
	private Mono<ServerResponse> filterLogic(ServerRequest request, HandlerFunction<ServerResponse> next) {
		// 取出请求头
		String userName = request.headers().header(HEADER_NAME).get(0);
		String password = request.headers().header(HEADER_VALUE).get(0);
		// 验证通过的条件
		if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password) && !userName.equals(password)) {
			// 接受请求
			return next.handle(request);
		}
		// 请求头不匹配，则不允许请求，返回为未签名错误
		return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
	}

	@Bean
	public RouterFunction helloWorldRouterFunction(){
		RequestPredicate requestPredicate = GET("/webflux");
		HandlerFunction handlerFunction =  new HandlerFunction(){
			//处理请求
			@Override
			public Mono handle(ServerRequest serverRequest) {
//				return Mono.just("hello");
				return ServerResponse.ok().body(Mono.just("hello"),String.class);
			}
		};
		return route(requestPredicate,handlerFunction);

//		return route(GET("webflux"),serverRequest -> ok().body(Mono.just("hello"),String.class));
	}

	@Bean
	public RouterFunction userRouterFunction(){
//		return route(GET("/webflux/user"),serverRequest -> {
//			Mono<User> userMono = serverRequest.bodyToMono(User.class);
//			Mono<String> stringMono = userMono.map(user-> user.toString());
//			return ServerResponse.ok().body(stringMono,String.class);
//		});
		return route(GET("/webflux/user"),serverRequest -> {
//			Mono<User> userMono = serverRequest.bodyToMono(User.class);
//			Mono<String> stringMono = userMono.map(user-> user.toString());
			return ServerResponse.ok().body(
					serverRequest.bodyToMono(User.class)
							     .subscribeOn(Schedulers.parallel())//并行执行
							     .map(User::toString),
					String.class);
		});
	}
}