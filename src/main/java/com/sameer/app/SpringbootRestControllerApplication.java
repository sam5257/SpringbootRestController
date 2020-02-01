package com.sameer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

//To run the application, we need to use @SpringBootApplication annotation.
// Behind the scenes, that’s equivalent to @Configuration, @EnableAutoConfiguration, and @ComponentScan together.
//It enables the scanning of config classes, files and load them into spring context.
// In below example, execution start with main() method. It start loading all the config files,
// configure them and bootstrap the application based on application properties in application.properties
// file in /resources folder.Spring boot is mostly about auto-configuration.
// This auto-configuration is done by component scanning i.e. finding all classes in classspath for
// @Component annotation. It also involve scanning of @Configuration annotation and initialize some extra beans.

@SpringBootApplication
@EnableJpaRepositories("com.sameer.utility")
@ComponentScan("com.sameer")
@EntityScan("com.sameer.model")
@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringbootRestControllerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringbootRestControllerApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(SpringbootRestControllerApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanNames);

		for (String beanName : beanNames)
		{
			System.out.println(beanName);
		}
	}

}
