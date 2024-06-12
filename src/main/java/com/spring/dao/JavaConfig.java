	package com.spring.dao;
	
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	
	@Configuration
	public class JavaConfig {
		
		@Bean("ds")
		public DriverManagerDataSource getDatasource()
		{
			DriverManagerDataSource ds = new DriverManagerDataSource ();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://127.0.0.1:3306/productproject");
			ds.setUsername("root");
			ds.setPassword("prashant@123");
			
			return ds;
		}
		
		@Bean("temp")
		public JdbcTemplate getTemplate()
		{
			JdbcTemplate temp = new JdbcTemplate();
			temp.setDataSource(getDatasource());
			return temp;
		}
		
		@Bean("dao")
		public ImplementInterfaceDao getImplInterfaceDao()
		{
			ImplementInterfaceDao impledao = new ImplementInterfaceDao();
			impledao.setTemp(getTemplate());
			return impledao;
		}
	}
