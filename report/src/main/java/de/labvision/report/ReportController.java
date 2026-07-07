package de.labvision.report;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private final ReportService reportService = new ReportService();

    @GetMapping("/report")
    public String createReport(@RequestParam("analysisResult") String analysisResult) {
        return reportService.createReport(analysisResult);
    }
}