package com.football.manager.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static com.football.manager.entity.WideTableTeamComparableTest.FIRST;
import static com.football.manager.entity.WideTableTeamComparableTest.SECOND;
import static com.football.manager.entity.WideTableTeamComparableTest.THIRD;

public class OverUnderTableTeamComparableTest {

    @Test
    public void testSortShouldBeByTeamNameAsc() {
        OverUnderTableTeam first = new OverUnderTableTeamImpl();
        first.setTeamName(SECOND);
        OverUnderTableTeam second = new OverUnderTableTeamImpl();
        second.setTeamName(THIRD);
        OverUnderTableTeam third = new OverUnderTableTeamImpl();
        third.setTeamName(FIRST);

        ArrayList<OverUnderTableTeam> tableTeams = new ArrayList<>();
        tableTeams.add(first);
        tableTeams.add(second);
        tableTeams.add(third);

        Collections.sort(tableTeams);

        Assert.assertTrue(FIRST.equals(tableTeams.get(0).getTeamName()));
        Assert.assertTrue(SECOND.equals(tableTeams.get(1).getTeamName()));
        Assert.assertTrue(THIRD.equals(tableTeams.get(2).getTeamName()));
    }

}