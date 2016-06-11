package com.certainhackathon.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.certainhackathon.auth.security.AuthenticationManagerService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationManagerService authenticationManagerService;
	
	@Autowired
	AuthSuccess authSuccess;
	
	@Autowired
	AuthFailure authFailure;
	
	@Autowired
	LogoutSuccess logoutSuccess;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * disabling the authentiaction for now
		 */
		http.httpBasic().disable()
			.csrf().disable().authorizeRequests()
			.antMatchers("/**/**").permitAll();
		/*http
			.httpBasic().disable()
			//.csrf().disable()
			.authorizeRequests()
			.antMatchers("/index.html", "/fonts/**", "/js/**", 
					"/scripts/**", "/views/**", "/images/**", 
					"/css/**", "/angular/**", "/certain-hackthon/**", 
					"/", "/unsecure/**", "/user/**", "/login/**", "/bootstrap/**")
			.permitAll().anyRequest().authenticated().and()
			.formLogin().successHandler(authSuccess)
			.failureHandler(authFailure).and()
			.logout()
			.logoutSuccessHandler(logoutSuccess)
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.and()
			.exceptionHandling().authenticationEntryPoint(new SecutiryAuthenticationEntryPoint())
			.and()
			.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
			.csrf().csrfTokenRepository(csrfTokenRepository());*/
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(authenticationManagerService)
		.passwordEncoder(new Md5PasswordEncoder());
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
	
	
	

	public static class CsrfHeaderFilter extends OncePerRequestFilter{

		@Override
		protected void doFilterInternal(HttpServletRequest request,
				HttpServletResponse response, FilterChain filterChain)
				throws ServletException, IOException {
			CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
			        .getName());
			    if (csrf != null) {
			      Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
			      String token = csrf.getToken();
			      if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
			        cookie = new Cookie("XSRF-TOKEN", token);
			        cookie.setPath("/");
			        response.addCookie(cookie);
			      }
			    }
			    filterChain.doFilter(request, response);
			
		}
		
	}
	
}
