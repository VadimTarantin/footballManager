package com.football.manager.util;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ParserMappingTest {

    @Test
    public void testGetParsersMappingValues() {
        Map<Integer, String> parsersMapping = ParsersMapping.getParsersMapping();

        assertTrue(parsersMapping.size() == 3);

        String wide = parsersMapping.get(1);
        String form = parsersMapping.get(2);
        String overUnder = parsersMapping.get(3);

        assertEquals(wide, "competition_wide_table");
        assertEquals(form, "competition_form_table");
        assertEquals(overUnder, "competition_overunder_table");
    }

    @Test
    public void testParserMappingsGetTypeForOne() {
        String type = ParsersMapping.getType(1);

        assertEquals(type, "competition_wide_table");
    }

    @Test
    public void testParserMappingsGetTypeForTwo() {
        String type = ParsersMapping.getType(2);

        assertEquals(type, "competition_form_table");
    }

    @Test
    public void testParserMappingsGetTypeForThree() {
        String type = ParsersMapping.getType(3);

        assertEquals(type, "competition_overunder_table");
    }

}