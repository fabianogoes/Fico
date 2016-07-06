package br.com.fico;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class FicoApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(FicoApplication.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/login").setViewName("login");
	}

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CharacterEncodingFilter characterEncodingFilter() {
      CharacterEncodingFilter filter = new CharacterEncodingFilter();
      filter.setEncoding("UTF-8");
      filter.setForceEncoding(true);
      return filter;
    }	
	
    @Bean
    public DataSource dataSource() {
    	/**********************************************************************************************
    	 * OpenShift Details
    	 **********************************************************************************************
    	 * app root         : sys-codeforse.rhcloud.com
    	 * final deploy Fico: sys-codeforse.rhcloud.com/fico 
    	 * Souce Code Git   : ssh://577d479d2d5271b1bd0001c3@sys-codeforse.rhcloud.com/~/git/sys.git/
    	 * Remote Access    : ssh 577d479d2d5271b1bd0001c3@sys-codeforse.rhcloud.com
    	 **********************************************************************************************
    	 * MySQL 5.5 database added.  Please make note of these credentials:
    	 **********************************************************************************************
		 *	
		 *     Root User    : admintfpcZ4w
		 *	   Root Password: ct-I6cSv9uBb
		 *	   Database Name: sys
		 *	
		 *	Connection URL: mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/
		 *	
		 *	You can manage your new MySQL database by also embedding phpmyadmin.
		 *	The phpmyadmin username and password will be the same as the MySQL credentials above.    	 
    	 **********************************************************************************************/
    	
    	String host = System.getenv().get("OPENSHIFT_MYSQL_DB_HOST") == null ? "localhost" : System.getenv().get("OPENSHIFT_MYSQL_DB_HOST");
    	String port = System.getenv().get("OPENSHIFT_MYSQL_DB_PORT") == null ? "3306" : System.getenv().get("OPENSHIFT_MYSQL_DB_PORT");
    	String database = "fico";
    	String user = System.getenv().get("OPENSHIFT_MYSQL_DB_USERNAME") == null ? "root" : System.getenv().get("OPENSHIFT_MYSQL_DB_USERNAME");
    	String password = System.getenv().get("OPENSHIFT_MYSQL_DB_PASSWORD") == null ? "root" : System.getenv().get("OPENSHIFT_MYSQL_DB_PASSWORD");
    	String url = System.getenv().get("OPENSHIFT_MYSQL_DB_URL") == null ? "jdbc:mysql://"+host+":"+port+"/"+database : System.getenv().get("OPENSHIFT_MYSQL_DB_URL");
    	
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url(url);
            dataSourceBuilder.username(user);
            dataSourceBuilder.password(password);
            return dataSourceBuilder.build();   
    }   	
	
}
