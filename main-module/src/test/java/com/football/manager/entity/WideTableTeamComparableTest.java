package com.football.manager.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class WideTableTeamComparableTest {

    static final String FIRST = "abc";
    static final String SECOND = "mnp";
    static final String THIRD = "xyz";

    @Test
    public void testSortShouldBeByTeamNameAsc() {
        WideTableTeam first = new WideTableTeam();
        first.setTeamName(SECOND);
        WideTableTeam second = new WideTableTeam();
        second.setTeamName(THIRD);
        WideTableTeam third = new WideTableTeam();
        third.setTeamName(FIRST);

        ArrayList<TableTeam> tableTeams = new ArrayList<>();
        tableTeams.add(first);
        tableTeams.add(second);
        tableTeams.add(third);

        Collections.sort(tableTeams);

        Assert.assertTrue(FIRST.equals(tableTeams.get(0).getTeamName()));
        Assert.assertTrue(SECOND.equals(tableTeams.get(1).getTeamName()));
        Assert.assertTrue(THIRD.equals(tableTeams.get(2).getTeamName()));
    }

}