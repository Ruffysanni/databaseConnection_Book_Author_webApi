package com.ruffy.database.connection;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabaseConnectionApplication {
//public class DatabaseConnectionApplication implements CommandLineRunner {
//	private DataSource dataSource;
//
//	public DatabaseConnectionApplication(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseConnectionApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		log.info("Datasource: "+ dataSource);
//		JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
//		restTemplate.execute("select 1");
//	}
}
