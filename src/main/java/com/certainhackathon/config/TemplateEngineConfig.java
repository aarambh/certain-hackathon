package com.certainhackathon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class TemplateEngineConfig {

	@Bean
	public TemplateEngine addTemplateResolvers() {
		TemplateEngine engine = new TemplateEngine();
		
		engine.setTemplateResolver(resolver());
		return engine;
	}

	@Bean
	public ClassLoaderTemplateResolver resolver() {
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setPrefix("email/");
		resolver.setTemplateMode("HTML5");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setOrder(1);
		resolver.setCacheable(true);
		return resolver;
	}

}
