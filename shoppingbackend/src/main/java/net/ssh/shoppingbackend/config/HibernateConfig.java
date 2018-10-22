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
	private static final String URL = "jdbc:postgresql://ec2-23-21-171-249.compute-1.amazonaws.com/d1nc449sckrgjn?sslmode=require";
	private static final String username = "ixlfrhwteqtgfm";
	private static final String password = "fa6e379534f568be03316f47d975ae1e6f61920d0988f8fc93f40e871ffda07a";
	
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
