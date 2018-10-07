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
		
	private static final String driverClassName = "org.h2.Driver";
	private static final String URL = "jdbc:h2:tcp://localhost/~/online";
	private static final String username = "sa";
	private static final String password = "";
	
	@Bean
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
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
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
