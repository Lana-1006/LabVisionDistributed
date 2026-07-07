package de.labvision.upload;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UploadController {

    private final UploadService uploadService = new UploadService();
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/upload")
    public String uploadImage(@RequestParam("imageName") String imageName) {
        boolean uploaded = uploadService.uploadImage(imageName);

        if (!uploaded) {
            return "Upload-Service result: Upload failed. No image selected.";
        }

        String analysisUrl = "http://localhost:8084/analysis?imageName=" + imageName;

        String analysisResponse = restTemplate.getForObject(analysisUrl, String.class);

        return "Upload-Service result: Image uploaded: " + imageName
                + "<br><br>"
                + "Analysis-Service response:<br>"
                + analysisResponse;
    }
}