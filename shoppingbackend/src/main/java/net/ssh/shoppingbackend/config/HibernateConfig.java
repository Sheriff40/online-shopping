package net.ssh.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "net.ssh.shoppingbackend.dto")
@EnableTransactionManagement
public class HibernateConfig {
		
	private static final String driverClassName = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://ec2-54-163-235-56.compute-1.amazonaws.com/d22slmmimmgpc?sslmode=require";
	private static final String username = "cigemprjlolcgk";
	private static final String password = "0a81ecd578a6f524f81d409fa443f6c44b0b9112f73cb8fcbd632f6b6fd5a9e8";
	
	@Bean(name = "dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(URL);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sb = new LocalSessionFactoryBuilder(dataSource);
		sb.addProperties(getHibernateProperties());
		sb.scanPackages("net.ssh.shoppingbackend.dto");
		return sb.buildSessionFactory();
		
	}


	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.auto","update");
		return properties;
	}
	
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager htm = new HibernateTransactionManager(sessionFactory);
		return htm;
	}

}
