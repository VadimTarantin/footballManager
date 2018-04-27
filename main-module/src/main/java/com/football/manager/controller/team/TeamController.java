package com.football.manager.controller.team;

import com.football.manager.entity.Team;
import com.football.manager.service.domain.TeamService;
import com.football.manager.service.domain.exception.ServiceException;
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
        List<Team> allTeams = null;
        String errorMessage = null;
        try {
            teamService.getAll();
        } catch (ServiceException e) {
            errorMessage = e.getMessage();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teams/teams");
        modelAndView.addObject("teams", allTeams);
        modelAndView.addObject("errorMessage", errorMessage);
        return modelAndView;
    }

}