package de.labvision.upload;

public class UploadService {

    public boolean uploadImage(String imageName) {
        return imageName != null && !imageName.isEmpty();
    }
}
