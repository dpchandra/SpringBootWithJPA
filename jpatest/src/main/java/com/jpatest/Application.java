package com.jpatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.jpatest.controller"})
@EnableJpaRepositories(basePackages = {"com.persistence.repository"})
@EntityScan("com.persistence.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(false);
//        vendorAdapter.setShowSql(false);
//        vendorAdapter.setDatabase(Database.MYSQL);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.saddlepoint.persistence.entities", "com.saddlepoint.persistence.controllers", "com.saddlepoint.persistence.controllers.impl", "com.saddlepoint.persistence.controllers.exceptions");
//        return factory.getObject();
//    }
}
