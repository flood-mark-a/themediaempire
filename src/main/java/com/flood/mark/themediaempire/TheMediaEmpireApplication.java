package com.flood.mark.themediaempire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class TheMediaEmpireApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(TheMediaEmpireApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").anonymous();
	}

}
