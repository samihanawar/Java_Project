package com.crimeRepo.crs.controller;
import com.crimeRepo.crs.entities.User;
import com.crimeRepo.crs.service.CitizenService;
import com.crimeRepo.crs.service.PoliceService;
import org.hibernate.id.enhanced.PooledLoOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller
public class PoliceController {

    @Autowired
    private PoliceService policeService;

    @GetMapping("/admin/polili")
    public String viewPolice(Model model) {
        List<User> police = policeService.getAllPolice();
        model.addAttribute("police", police);
        return "police_list";
    }
}
