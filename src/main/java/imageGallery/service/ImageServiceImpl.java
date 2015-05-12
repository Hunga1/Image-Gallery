package imageGallery;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageRepository imageRepository;

	@Transactional
	public void saveImage(Image image) {
		imageRepository.save(image);

		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/images/" + Long.toString(image.getId()) + ".jpg")));
			stream.write(image.getImage());
			stream.close();
		} catch (Exception e) {
			System.out.println("You have failed to create " + String.valueOf(image.getId()) + ": " + e.getMessage());
		}
	}

	@Transactional
	public List<Image> getAllImages() {
		List<Image> images = new ArrayList<Image>();
		images = imageRepository.findAll();

		for (int i = 0; i < images.size(); i++) {
			images.get(i).setFilename("images/" + String.valueOf(images.get(i).getId()) + ".jpg");
		}

		return images;
	}
}