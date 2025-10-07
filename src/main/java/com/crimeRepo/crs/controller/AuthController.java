package com.crimeRepo.crs.controller;

import com.crimeRepo.crs.entities.User;
import com.crimeRepo.crs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password,
                               RedirectAttributes redirectAttributes) {
        try {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole("USER");
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please log in.");
            return "redirect:/login";

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("errorMessage", "Registration failed: " + e.getMessage());
            return "redirect:/register/user";
        }
    }


    @PostMapping("/register/police")
    public String registerPolice(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String password,
                                 RedirectAttributes redirectAttributes) {
        try {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole("POLICE");
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please log in.");
            return "redirect:/login";

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("errorMessage", "Registration failed: " + e.getMessage());
            return "redirect:/register/police";
        }
    }

//    @PostMapping("/register")
//    public String register(@RequestParam String name,
//                           @RequestParam String email,
//                           @RequestParam String password,
//                           @RequestParam String role) {
//        User user = new User();
//        user.setName(name);
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setRole(role.toUpperCase());
//        userRepository.save(user);
//        return "redirect:/login";
//    }


    @PostMapping("/register/admin")
    public String registerAdmin(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String password,
                                RedirectAttributes redirectAttributes) {
        try {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole("ADMIN");
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please log in.");
            return "redirect:/login";

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("errorMessage", "Registration failed: " + e.getMessage());
            return "redirect:/register/admin";
        }
    }

    @GetMapping("/")
    public String homePage() { return "home"; }


    @GetMapping("/login")
    public String loginPage() { return "login"; }

//    @GetMapping("/dashboard")
//    public String dashboard() { return "dashboard"; }

    @GetMapping("/register/user")
    public String registerUserPage() { return "register-user"; }

    @GetMapping("/register/police")
    public String registerPolicePage() { return "register-police"; }

    @GetMapping("/register/admin")
    public String registerAdminPage() { return "register-admin"; }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() { return "admin_dash"; }

    @GetMapping("/police/dashboard")
    public String policeDashboard() { return "police_dash"; }

    @GetMapping("/user/dashboard")
    public String userDashboard() { return "user_dash"; }

//    @GetMapping("/new/report")
//    public String createReportPage() { return "create_report"; }
//
//    @GetMapping("/My_reports")
//    public String ReportsPage() { return "My_Reports"; }

    @GetMapping("/reportDetails")
    public String ReportDetailsPage() { return "Report_details"; }

    @GetMapping("/report/view")
    public String ReportlistPage() { return "view_reports"; }
    @GetMapping("/chcid")
    public String chooseReportIdPage() { return "choose_case_id"; }

    @GetMapping("/pur")
    public String ReportUpdatePage() { return "police_update_report"; }

    @GetMapping("/citili")
    public String citizenListPage() { return "citizen_List"; }

    @GetMapping("/polili")
    public String policeListPage() { return "police_list"; }

    @GetMapping("/learn")
    public String learnPage() { return "learn"; }

    @GetMapping("/abira")
    public String abira() { return "abira"; }

}



