package com.umnikov.scannerservice.config;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DatabaseConfiguration {
  private static final String[] PACKAGES = {"com.umnikov.scannerservice.entity"};
  @Resource
  private Environment environment;

  @Bean
  private DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("database.driver"));
    dataSource.setJdbcUrl(environment.getRequiredProperty("database.url"));
    dataSource.setUsername(environment.getRequiredProperty("database.username"));
    dataSource.setPassword(environment.getRequiredProperty("database.password"));
    return dataSource;
  }

  @Bean(name = "scannerSessionFactory")
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(PACKAGES);
    sessionFactory.setPhysicalNamingStrategy(new SpringPhysicalNamingStrategy());
    sessionFactory.setImplicitNamingStrategy(new SpringImplicitNamingStrategy());
    sessionFactory.setHibernateProperties(getHibernateProperties());
    return sessionFactory;
  }

  @Bean
  public HibernateTransactionManager transactionManager(
      @Qualifier("scannerSessionFactory") final SessionFactory sessionFactory) {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(sessionFactory);
    return txManager;
  }

  private Properties getHibernateProperties() {
    Properties properties = new Properties();
    properties.put(AvailableSettings.DIALECT, environment.getRequiredProperty("hibernate.dialect"));
    properties.put(AvailableSettings.SHOW_SQL, environment.getRequiredProperty("hibernate.show_sql"));
    properties.put(AvailableSettings.FORMAT_SQL, environment.getRequiredProperty("hibernate.format_sql"));
    properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, environment.getRequiredProperty("hibernate.jdbc.batch_size"));
    properties.put(AvailableSettings.BATCH_VERSIONED_DATA, environment.getRequiredProperty("hibernate.jdbc.batch_versioned_data"));
    return properties;
  }
}
