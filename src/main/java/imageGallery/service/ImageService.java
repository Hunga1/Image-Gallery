package imageGallery;

import java.util.List;

import org.springframework.stereotype.Service;

public interface ImageService {

	public void saveImage(Image image);
	public List<Image> getAllImages();
}