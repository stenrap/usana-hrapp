package com.usana.hrapp.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    @Value("${hibernate.connection.driver_class}")
    private String databaseDriverClass;

    @Autowired
    @Value("${hibernate.connection.url}")
    private String databaseUrl;

    @Autowired
    @Value("${hibernate.connection.username}")
    private String databaseUsername;

    @Autowired
    @Value("${hibernate.connection.password}")
    private String databasePassword;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriverClass);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        return dataSource;
    }

    @Bean
    public SessionFactory getSessionFactory() throws IOException {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(getDataSource());
        lsfb.setPackagesToScan(new String[] {"com.usana.hrapp.models"});
        lsfb.afterPropertiesSet();
        return lsfb.getObject();
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws NamingException, IOException {
        HibernateTransactionManager htm = new HibernateTransactionManager(getSessionFactory());
        return htm;
    }

}
