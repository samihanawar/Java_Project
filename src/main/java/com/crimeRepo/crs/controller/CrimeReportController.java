package com.crimeRepo.crs.controller;
import com.crimeRepo.crs.entities.CrimeReport;
import com.crimeRepo.crs.entities.User;
import com.crimeRepo.crs.repository.CrimeReportRepository;
import com.crimeRepo.crs.service.CrimeReportService;
//this import
import com.crimeRepo.crs.service.UserService;
import jakarta.servlet.http.HttpSession;
//this also
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/report")
public class CrimeReportController {

    private final CrimeReportService reportService;
    //ting
    private final UserService userService;
    private final CrimeReportRepository crimeReportRepository;

    public CrimeReportController(CrimeReportService reportService, /*UserService*/
                                 UserService userService,
                                 CrimeReportRepository crimeReportRepository) {

        this.reportService = reportService;
        //this line too
        this.userService = userService;
        this.crimeReportRepository = crimeReportRepository;
    }

    @GetMapping("/create")
    public String createReportForm(Model model) {
        model.addAttribute("report", new CrimeReport());
        return "create_report";
    }


    //perfectly working code
//    @PostMapping("/save")
//    public String saveReport(@ModelAttribute CrimeReport report, HttpSession session) {
//
//        User loggedInUser = (User) session.getAttribute("user");
//        if (loggedInUser != null) {
//            report.setUser(loggedInUser);
//        }
//        reportService.saveReport(report);
//        return "redirect:/user/dashboard";
//    }

    @PostMapping("/save")
    public String saveReport(@ModelAttribute CrimeReport report, Authentication authentication) {
        if (authentication != null) {
            String email = authentication.getName(); // logged-in user’s email
            User loggedInUser = userService.findByEmail(email); // load User by email
            report.setUser(loggedInUser);
        }
        System.out.println("Saving report for user id: " + report.getUser().getId());

        reportService.saveReport(report);
        return "redirect:/user/dashboard";
    }

    @GetMapping("/all")
    public String viewAllReports(Model model) {
        model.addAttribute("reports", reportService.getAllReports());
        return "view_reports";
    }

    @GetMapping("/my")
    public String myReports(Model model, Authentication authentication) {
        if (authentication != null) {
            String email = authentication.getName();
            User loggedInUser = userService.findByEmail(email);
            Long userId = loggedInUser.getId();
            model.addAttribute("myReports", reportService.getReportsByUserId(userId));
        }
        return "My_Reports";
    }

    @GetMapping("/update")
    public String findReportById(@RequestParam("id") Long id, Model model) {
        CrimeReport report = reportService.getReportById(id);

        if (report == null) {
            model.addAttribute("error", "No report found with ID " + id);
            return "choose_case_id";
        }

        model.addAttribute("report", report);
        return "police_update_report";
    }

    @PostMapping("/update/{id}")
    public String updateReport(@PathVariable Long id, @ModelAttribute CrimeReport updatedReport) {
        CrimeReport report = reportService.getReportById(id);

        if (report != null) {
            report.setStatus(updatedReport.getStatus());
            report.setRemarks(updatedReport.getRemarks());
            reportService.saveReport(report);
        }

        return "redirect:/report/all";
    }

    @GetMapping("/reports/{id}")
    public String viewReportDetails(@PathVariable Long id, Model model) {
        CrimeReport report = reportService.getReportById(id);

        if (report == null) {
            model.addAttribute("error", "No report found with ID " + id);
            return "view_reports"; // or a custom error page
        }

        model.addAttribute("report", report);
        return "Report_details";
    }





}
