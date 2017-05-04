package com.art.init;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan({"com.art.model"})
@PropertySource(value = {"classpath:App.properties"})
@EnableTransactionManagement
public class HibernateConfig {

    @Bean(name = "Session")
    public LocalSessionFactoryBean SessionFactory (){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("WebApi");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return  sessionFactory;
    }


    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql","true");
        properties.put("hibernate.connection.autocommit","true");
        properties.put("connection.autoReconnect=true","true");
        properties.put("hibernate.autoReconnect","true");
        properties.put("hibernate.connection.pool_size=","10");
        return properties;
    }
/**
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSourse = new DriverManagerDataSource();
        dataSourse.setDriverClassName(environment.getRequiredProperty("jdbc.driverClass"));
        dataSourse.setUsername(environment.getRequiredProperty("jdbc.user"));
        dataSourse.setPassword(environment.getRequiredProperty("jdbc.pass"));
        dataSourse.setUrl(environment.getRequiredProperty("jdbc.url"));
    return dataSourse;
    }
*/
@Bean
public DataSource dataSource() {
    String dbUrl = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_f163f738eafd43c?reconnect=true";
    String username = System.getenv("JDBC_DATABASE_USERNAME");
    String password = System.getenv("JDBC_DATABASE_PASSWORD");

    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setUrl(dbUrl);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
}


    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s ) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager ;
    }
}
