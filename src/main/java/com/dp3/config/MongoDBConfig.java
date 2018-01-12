package com.dp3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;

@EnableMongoRepositories(basePackages = "com.dp3.dao")
@EnableMongoHttpSession
@Configuration
public class MongoDBConfig {

	@Bean
	public JdkMongoSessionConverter jdkMongoSessionConverter() {
		return new JdkMongoSessionConverter();
	}

	// @Bean
	// public MongoDbFactory mongoDbFactory2() throws Exception {
	// return new SimpleMongoDbFactory(new MongoClient(), "sdv");
	// }
	//
	// @Bean
	// public MongoTemplate mongoTemplate2() throws Exception {
	//
	// MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory2());
	// return mongoTemplate;
	// }

	// @Bean
	// public MongoOperations mongoOperations2() throws Exception {
	// return mongoTemplate2();
	// }

	// @Autowired
	// private ApplicationContext appContext;
	//
	// @Bean
	// public static PropertySourcesPlaceholderConfigurer
	// propertySourcesPlaceholderConfigurer() {
	// return new PropertySourcesPlaceholderConfigurer();
	// }
	//
	// @Bean
	// public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	// HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	// adapter.setDatabase(Database.MYSQL);
	// LocalContainerEntityManagerFactoryBean emfb = new
	// LocalContainerEntityManagerFactoryBean();
	// emfb.setDataSource(appContext.getBean(DataSource.class));
	// emfb.setPersistenceUnitName("entityManagerFactory");
	// emfb.setPackagesToScan("com.depetris.domain");
	// emfb.setJpaVendorAdapter(adapter);
	// return emfb;
	// }
	//
	// @Bean
	// public PlatformTransactionManager transactionManager(EntityManagerFactory
	// emf) {
	// return new JpaTransactionManager(emf);
	// }
}