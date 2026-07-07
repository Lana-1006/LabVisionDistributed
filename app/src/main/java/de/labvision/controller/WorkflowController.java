package de.labvision.controller;

import de.labvision.analysis.AnalysisService;
import de.labvision.auth.AuthService;
import de.labvision.report.ReportService;
import de.labvision.upload.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkflowController {

    private final AuthService authService;
    private final UploadService uploadService;
    private final AnalysisService analysisService;
    private final ReportService reportService;

    public WorkflowController(AuthService authService,
                              UploadService uploadService,
                              AnalysisService analysisService,
                              ReportService reportService) {
        this.authService = authService;
        this.uploadService = uploadService;
        this.analysisService = analysisService;
        this.reportService = reportService;
    }

    @GetMapping("/")
    public String showWorkflow(Model model) {
        String username = "user";
        String password = "password";
        String imageName = "sample.png";

        boolean loggedIn = authService.login(username, password);
        model.addAttribute("loginResult", loggedIn ? "Login successful" : "Login failed");

        boolean uploaded = uploadService.uploadImage(imageName);
        model.addAttribute("uploadResult", uploaded ? "Image uploaded: " + imageName : "Upload failed");

        String analysisResult = analysisService.analyzeImage(imageName);
        model.addAttribute("analysisResult", analysisResult);

        String report = reportService.createReport(analysisResult);
        model.addAttribute("reportResult", report);

        return "index";
    }
}
