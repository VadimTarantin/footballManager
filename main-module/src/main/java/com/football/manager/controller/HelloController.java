package com.football.manager.controller;

import com.football.manager.service.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String sayHello() {
        return answerForHello;
    }

    @RequestMapping(path = "/rest", method = RequestMethod.GET)
    @ResponseBody
    public String getRest() {
        return restMessage;
    }

}