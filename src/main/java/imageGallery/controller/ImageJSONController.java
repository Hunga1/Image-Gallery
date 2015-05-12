package imageGallery;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ImageJSONController {

	@Autowired
	private ImageService imageService;

	@RequestMapping("/getImages")
	public List<ImagesJSON> getImages() {
		List<Image> images = new ArrayList<Image>();
		List<ImagesJSON> imagesJSON = new ArrayList<ImagesJSON>();

		images = imageService.getAllImages();

		for (int i = 0; i < images.size(); i++) {
			ImagesJSON imageJSON = new ImagesJSON();

			imageJSON.setId(images.get(i).getId());
			imageJSON.setTitle(images.get(i).getTitle());
			imageJSON.setDescription(images.get(i).getDescription());
			imageJSON.setFilename("http://localhost:8080/images/" + Long.toString(imageJSON.getId()) + ".jpg");

			imagesJSON.add(imageJSON);
		}

		return imagesJSON;
	}
}