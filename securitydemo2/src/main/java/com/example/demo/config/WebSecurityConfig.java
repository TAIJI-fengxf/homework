package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	@Autowired
	private CustomFilter customFilter;
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//super.configure(auth);
		auth.jdbcAuthentication()
			.dataSource(dataSource);
			/*.withDefaultSchema()
			.withUser("1").password("1").roles("USER")
	        .and().withUser("2").password("2").roles( "ADMIN");*/
		auth.authenticationProvider(customAuthenticationProvider);
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests()
        // 主要URl匹配的优先级问题，不要配置冲突
        .antMatchers("/h2-console/**")
        .permitAll()
        .anyRequest().access("@customAccessControlService.canAccess(request,authentication)");
        /*.access("hasRole('ADMIN') and hasRole('Read')")
        
        .anyRequest().authenticated();*/

		http.formLogin();
		
		//http.csrf().disable();
		//禁用H2控制台的CSRF防护
		http.csrf().ignoringAntMatchers("/h2-console/**");
		//允许来自同一来源的H2控制台的请求
		http.headers().frameOptions().sameOrigin();
		
		http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
		web.ignoring().antMatchers("/favicon.ico","/css/**","/image/**","/js/**");
	}

	
}
