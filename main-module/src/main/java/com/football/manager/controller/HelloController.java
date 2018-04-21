package com.football.manager.controller;

import com.football.manager.service.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Value("${hello.jsp}")
    private String answerForHello;

    @Value("${rest.message}")
    private String restMessage;

    @Autowired
    private Parser parser;

    public void setAnswerForHello(String answerForHello) {
        this.answerForHello = answerForHello;
    }

    public void setRestMessage(String restMessage) {
        this.restMessage = restMessage;
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public ModelAndView sayHello(ModelAndView modelAndView) {
        modelAndView.setViewName(answerForHello);
        return modelAndView;
    }

    @RequestMapping(path = "/rest", method = RequestMethod.GET)
    @ResponseBody
    public String getRest() {
        return restMessage;
    }

}