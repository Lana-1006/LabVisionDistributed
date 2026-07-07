package de.labvision.config;

import de.labvision.analysis.AnalysisService;
import de.labvision.auth.AuthService;
import de.labvision.report.ReportService;
import de.labvision.upload.UploadService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AuthService authService() {
        return new AuthService();
    }

    @Bean
    public UploadService uploadService() {
        return new UploadService();
    }

    @Bean
    public AnalysisService analysisService() {
        return new AnalysisService();
    }

    @Bean
    public ReportService reportService() {
        return new ReportService();
    }
}
