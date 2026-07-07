package de.labvision.analysis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AnalysisController {

    private final AnalysisService analysisService = new AnalysisService();
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/analysis")
    public String analyzeImage(@RequestParam("imageName") String imageName) {
        String analysisResult = analysisService.analyzeImage(imageName);

        String reportUrl = "http://localhost:8085/report?analysisResult=" + analysisResult;

        String reportResult = restTemplate.getForObject(reportUrl, String.class);

        return "Analysis-Service result: " + analysisResult
                + "<br><br>"
                + "Report-Service response: " + reportResult;
    }
}