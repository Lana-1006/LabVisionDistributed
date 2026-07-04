package de.labvision.analysis;

public class AnalysisService {

    public String analyzeImage(String imageName) {
        if (imageName == null || imageName.isEmpty()) {
            return "No image selected";
        }
        return "Analysis completed for " + imageName;
    }
}
