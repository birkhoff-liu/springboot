package com.birkhoff.boot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SpringBootApplication
@EnableCaching//使用注解驱动缓存机制
@MapperScan(basePackages = "com.birkhoff.boot", annotationClass = Mapper.class)
public class SecurityApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	// 注入数据源
	@Autowired
	private DataSource dataSource = null;

	@Value("${system.user.password.secret}")
	private String secret = null;

	@Autowired
	private  UserDetailsService userDetailsService= null;

	@Autowired
	private RedisTemplate redisTemplate = null;

	/**
	 * 覆盖WebSecurityConfigurerAdapter用户详情方法
	 *
	 * @param auth
	 *            用户签名管理器构造器
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// 访问/admin下的请求需要管理员权限
				.authorizeRequests().antMatchers("/admin/**")
				.access("hasRole('ADMIN')")
				// 通过签名后可以访问任何请求
				.and().authorizeRequests()
				.antMatchers("/**").permitAll()
				// 设置登录页和默认的跳转路径
				.and().formLogin().loginPage("/login/page")
				.defaultSuccessUrl("/admin/welcome1")
				// 登出页面和默认跳转路径
				.and().logout().logoutUrl("/logout/page")
				.logoutSuccessUrl("/welcome");
	}
	@PostConstruct
	public void initRedisTemplate() {
		RedisSerializer<String> strSerializer = redisTemplate.getStringSerializer();
		redisTemplate.setKeySerializer(strSerializer);
		redisTemplate.setHashKeySerializer(strSerializer);
	}

	// 使用用户名称查询密码
//	String pwdQuery = " select user_name, pwd, available" + " from t_user where user_name = ?";
//	// 使用用户名称查询角色信息
//	String roleQuery = " select u.user_name, r.role_name " + " from t_user u, t_user_role ur, t_role r "
//			+ "where u.id = ur.user_id and r.id = ur.role_id" + " and u.user_name = ?";

//	@Value("${system.user.password.secret}")
//	privatevate String secret = null;

//	@Autowired
//	private UserDetailsService UserDetailsService = null;

//	使用内存模式
//	 @Override
//	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 // 密码编码器
//		 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		 // 使用内存存储
//		 InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> userConfig
//			 = auth.inMemoryAuthentication()
//			 // 设置密码编码器
//			 .passwordEncoder(passwordEncoder);
//			 // 注册用户admin，密码为abc,并赋予USER和ADMIN的角色权限
//			 userConfig.withUser("admin")
//			 // 可通过passwordEncoder.encode("abc")得到加密后的密码
//			 .password("$2a$10$5OpFvQlTIbM9Bx2pfbKVzurdQXL9zndm1SrAjEkPyIuCcZ7CqR6je")
//			 .authorities("ROLE_USER", "ADMIN");
//
//			 // 注册用户myuser，密码为123456,并赋予USER的角色权限
//			 userConfig.withUser("myuser")
//			 // 可通过passwordEncoder.encode("123456")得到加密后的密码
//			 .password("$2a$10$ezW1uns4ZV63FgCLiFHJqOI6oR6jaaPYn33jNrxnkHZ.ayAFmfzLS")
//			 .roles("USER");
//	 }

//	/**
//	 * 使用数据模式
//	 * @param auth
//	 * @throws Exception
//	 */
//	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 // 密码编码器
//		 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		 auth.jdbcAuthentication()
//		 //密码编码器
//		 .passwordEncoder(passwordEncoder)
//		 // 数据源
//		 .dataSource(dataSource)
//		 // 查询用户，自动判断密码是否一致
//		 .usersByUsernameQuery(pwdQuery)
//		 // 赋予权限
//		 .authoritiesByUsernameQuery(roleQuery);
//	 }
}
