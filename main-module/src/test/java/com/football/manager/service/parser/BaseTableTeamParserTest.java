package com.football.manager.service.parser;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public abstract class BaseTableTeamParserTest {

    protected String getResponse(String fileName) throws Exception {
        File updateWideTable = new File(this.getClass().getClassLoader().getResource(fileName).getFile());
        BufferedReader reader = new BufferedReader(new FileReader(updateWideTable));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

}