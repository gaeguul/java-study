package org.scoula.config;

import com.zaxxer.hikari.*;
import javax.sql.*;
import org.apache.ibatis.session.*;
import org.mybatis.spring.*;
import org.mybatis.spring.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.*;

@Configuration
@PropertySource({"classpath:/application.properties"})
@MapperScan(basePackages = {"org.scoula.todo.mapper"})
public class RootConfig {

  @Value("${jdbc.driver}")
  String driver;
  @Value("${jdbc.url}")
  String url;
  @Value("${jdbc.username}")
  String username;
  @Value("${jdbc.password}")
  String password;

  @Bean
  public DataSource dataSource() {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName(driver);
    config.setJdbcUrl(url);
    config.setUsername(username);
    config.setPassword(password);
    HikariDataSource dataSource = new HikariDataSource(config);
    return dataSource;
  }

  @Autowired
  ApplicationContext applicationContext;

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
    sqlSessionFactory.setConfigLocation(
        applicationContext.getResource("classpath:/mybatis-config.xml"));
    sqlSessionFactory.setDataSource(dataSource());
    return (SqlSessionFactory) sqlSessionFactory.getObject();
  }

  @Bean
  public DataSourceTransactionManager transactionManager() {
    DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
    return manager;
  }
}
