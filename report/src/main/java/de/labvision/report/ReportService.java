package de.labvision.report;

public class ReportService {

    public String createReport(String analysisResult) {
        if (analysisResult == null || analysisResult.isEmpty()) {
            return "No analysis result available";
        }
        return "Report created: " + analysisResult;
    }
}
