package com.crimeRepo.crs.controller;

import com.crimeRepo.crs.entities.User;
import com.crimeRepo.crs.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @GetMapping("/admin/citizens")
    public String viewCitizens(Model model) {
        List<User> citizens = citizenService.getAllCitizens();
        model.addAttribute("citizens", citizens);
        return "citizen_List";
    }
}
