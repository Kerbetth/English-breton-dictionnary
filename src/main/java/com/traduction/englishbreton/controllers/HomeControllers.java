package com.traduction.englishbreton.controllers;


import com.traduction.englishbreton.service.HistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * -the root of the url give link to login or create an account
 * -userHome url is the main page of connected users
 */

@Controller
public class HomeControllers {

    @Autowired
    private HistoricService historicService;

    @RequestMapping("/")
    public String getLog(Model model) {
        return "LogPage";
    }

    @GetMapping("/userHome")
    public String userPage(Model model) {
            model.addAttribute("userAccount", historicService.getLastDescriptions());
            return "UserPage";
    }

}
