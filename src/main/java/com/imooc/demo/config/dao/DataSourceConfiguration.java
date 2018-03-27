package com.imooc.demo.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@MapperScan("com.imooc.demo.dao")
public class DataSourceConfiguration {
	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUsername;
	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Bean(name="dataSource")
	public ComboPooledDataSource createDataSource(){
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(jdbcDriver);
			dataSource.setJdbcUrl(jdbcUrl);
			dataSource.setUser(jdbcUsername);
			dataSource.setPassword(jdbcPassword);
			//Do not auto commit after close connection
			dataSource.setAutoCommitOnClose(false);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return dataSource;
		
	}
}
