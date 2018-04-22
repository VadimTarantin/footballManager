package com.football.manager.util.initializator;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.h2.tools.RunScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.util.Arrays;

public class HikariDataSourceWithDatabaseInitialization extends HikariDataSource {

    private static final Logger log = LoggerFactory.getLogger(HikariDataSourceWithDatabaseInitialization.class);

    public HikariDataSourceWithDatabaseInitialization() {
    }

    public HikariDataSourceWithDatabaseInitialization(HikariConfig configuration) {
        super(configuration);
    }

    public void databaseInitialize() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getDataSourceClassName());
        dataSource.setUrl("jdbc:h2:mem:FOOTBALL_MANAGER");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        log.info("Trying to execute sql-scripts for initializator...");
        try  (Connection conn = dataSource.getConnection()) {
            URL resource = this.getClass().getClassLoader().getResource("properties/sql");
            File file = new File(resource.getFile());
            File[] files = file.listFiles();
            log.info("Found sql for execution: ", Arrays.toString(files));
            for (File sql : files) {
                RunScript.execute(conn, new FileReader(sql));
            }
            log.info("Sql scripts were executed successful");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Cannot execute sql scripts", e);
        }
    }

}
