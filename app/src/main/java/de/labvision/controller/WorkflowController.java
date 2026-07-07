package de.labvision.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WorkflowController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String showWorkflow() {
        String username = "lana";
        String password = "password";
        String imageName = "sample.png";

        String authResponse = restTemplate.getForObject(
                "http://localhost:8081/login?username=" + username + "&password=" + password,
                String.class
        );

        String uploadResponse = restTemplate.getForObject(
                "http://localhost:8083/upload?imageName=" + imageName,
                String.class
        );

        return "<html>"
                + "<head><title>LabVision Distributed</title></head>"
                + "<body style='font-family: Arial; padding: 40px; background:#eef7fb;'>"
                + "<h1>LabVision Distributed Application</h1>"
                + "<h2>Verteilter Ablauf</h2>"
                + "<p>App-Service → Auth-Service → Upload-Service → Analysis-Service → Report-Service</p>"
                + "<hr>"
                + "<h2>Auth-Service Antwort</h2>"
                + "<p style='color:green; font-weight:bold;'>" + authResponse + "</p>"
                + "<h2>Upload / Analysis / Report Antwort</h2>"
                + "<p>" + uploadResponse + "</p>"
                + "<hr>"
                + "<p>Diese App läuft auf Port 8082 und ruft andere Services über HTTP auf.</p>"
                + "</body>"
                + "</html>";
    }
}