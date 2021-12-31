package com.example.friedgoldenflower.api.controller;

import com.example.friedgoldenflower.app.service.CardService;
import com.example.friedgoldenflower.fgf.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private CardService cardService;

    @GetMapping("/")
    public ModelAndView index(Integer count){
        LOGGER.info("index...");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/demo")
    public List<Player> demo(Integer count){
        LOGGER.info("demo...");
        List<Player> players = cardService.testLimitedPlayer(count);
        return players;
    }
}
