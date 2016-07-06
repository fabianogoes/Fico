package br.com.fico;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
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
    public DataSource dataSource() {
    	String host = System.getenv().get("OPENSHIFT_MYSQL_DB_HOST");
    	String port = System.getenv().get("OPENSHIFT_MYSQL_DB_PORT");;
    	String database = "fico";
    	String user = "adminA28iIul";
    	String password = "SVaVThtuYqCT";
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url("jdbc:mysql://"+host+":"+port+"/"+database);
            dataSourceBuilder.username(user);
            dataSourceBuilder.password(password);
            return dataSourceBuilder.build();   
    }   	
	
}
