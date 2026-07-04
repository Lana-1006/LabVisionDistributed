package de.labvision;

import de.labvision.analysis.AnalysisService;
import de.labvision.auth.AuthService;
import de.labvision.report.ReportService;
import de.labvision.upload.UploadService;

public class Main {

    public static void main(String[] args) {
        AuthService authService = new AuthService();
        UploadService uploadService = new UploadService();
        AnalysisService analysisService = new AnalysisService();
        ReportService reportService = new ReportService();

        String username = "user";
        String password = "password";
        String imageName = "sample.png";

        System.out.println("Step 1: Login");
        boolean loggedIn = authService.login(username, password);
        System.out.println(loggedIn ? "Login successful" : "Login failed");

        System.out.println("Step 2: Upload image");
        boolean uploaded = uploadService.uploadImage(imageName);
        System.out.println(uploaded ? "Image uploaded: " + imageName : "Upload failed");

        System.out.println("Step 3: Analyze image");
        String analysisResult = analysisService.analyzeImage(imageName);
        System.out.println(analysisResult);

        System.out.println("Step 4: Create report");
        String report = reportService.createReport(analysisResult);
        System.out.println(report);
    }
}
