package imageGallery;

import java.util.List;

import org.springframework.stereotype.Service;

public interface ImageService {

	public void saveImage(Image image);
	public List<Image> getAllImages();
	public Image getImageById(long Id);
	public boolean ImageIsJpg(byte[] imageData);
	public boolean ImageIsValidSize(byte[] imageData);
}