package com.football.manager.controller.team;

import com.football.manager.entity.Team;
import com.football.manager.service.domain.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(path = "/showTeams", method = RequestMethod.GET)
    public ModelAndView showAllTeams(){
        List<Team> allTeams = teamService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teams/teams");
        modelAndView.addObject("teams", allTeams);
        return modelAndView;
    }

    @RequestMapping(path = "/addTeam", method = RequestMethod.GET)
    public ModelAndView ModelAndView() {
        teamService.addTeam();
        List<Team> allTeams = teamService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teams/teams");
        modelAndView.addObject("teams", allTeams);
        return modelAndView;
    }

}