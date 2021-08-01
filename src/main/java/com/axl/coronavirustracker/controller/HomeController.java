package com.axl.coronavirustracker.controller;

import com.axl.coronavirustracker.models.LocationStats;
import com.axl.coronavirustracker.service.CoronavirusDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    CoronavirusDataService coronavirusDataService;

    public HomeController(CoronavirusDataService coronavirusDataService) {
        this.coronavirusDataService = coronavirusDataService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronavirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);
        model.addAttribute("totalNewCases",totalNewCases);
        return "home";
    }

}
