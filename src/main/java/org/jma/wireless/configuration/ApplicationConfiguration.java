/**
 * 
 */
package org.jma.wireless.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Needa-Con
 *
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "org.jma.wireless")
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
	
	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[]{"org.jma.wireless.model"});
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
	     
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	     
	    private final Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.ddl-auto"));
	        return properties;        
	    }
	     
	    @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("messages");
	        return messageSource;
	    }

	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager() {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(sessionFactory().getObject());
	       return txManager;
	    }

}
