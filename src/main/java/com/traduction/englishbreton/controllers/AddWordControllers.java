package com.traduction.englishbreton.controllers;


import com.traduction.englishbreton.dto.WordCreation;
import com.traduction.englishbreton.service.WordManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The user can registered one or many bank accounts in order to withdraw or deposit some money
 */

@Controller
public class AddWordControllers {

    @Autowired
    private WordManagementService wordManagementService;

    @GetMapping(value = "/userHome/wordCreation/add")
    public String addABankAccountToYourList(Model model) {
        model.addAttribute("wordCreation", new WordCreation());
        return "WordCreation";
    }

    @PostMapping(value = "/userHome/wordCreation/adding")
    public String addingABankAccount(WordCreation wordCreation) {
        if (!wordManagementService.addAWord(wordCreation)) {
            return "redirect:/userHome/wordCreation/add";
        }
        return "redirect:/userHome";
    }
}
