package com.dp3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		}
        registry.addResourceHandler("/favicon.ico");
	}
	
//	@Bean(name = "templateResolver")
//	public ServletContextTemplateResolver getTemplateResolver() {
//		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//		templateResolver.setPrefix("/");
//		templateResolver.setPrefix("/WEB-INF/templates/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode("XHTML");
//		return templateResolver;
//	}
//
//	@Bean(name = "templateEngine")
//	public SpringTemplateEngine getTemplateEngine() {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(getTemplateResolver());
//		return templateEngine;
//	}
//
//	@Bean(name = "viewResolver")
//	public ThymeleafViewResolver getViewResolver() {
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(getTemplateEngine());
//		return viewResolver;
//	}
	
	
}
