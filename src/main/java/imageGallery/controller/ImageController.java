package imageGallery;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/images", method = RequestMethod.GET)
	public String showImages(Model model) {
		List<Image> images = new ArrayList<Image>();
		images = imageService.getAllImages();
		model.addAttribute("images", images);
		
		return "gallery";
	}

	@RequestMapping(value = "/postImages", method = RequestMethod.GET)
	public String getImages() {

		return "postImages";
	}

	@RequestMapping(value = "/postImages", method = RequestMethod.POST)
	public String postImages(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("image") MultipartFile image) {

		if (!image.isEmpty()) {
			try {
				byte[] imageData = image.getBytes();

				Image imageObject = new Image();
				imageObject.setTitle(title);
				imageObject.setDescription(description);
				imageObject.setImage(imageData);

				imageService.saveImage(imageObject);

				System.out.println("success!");
			} catch (Exception e) {
				System.out.println("You have failed to upload " + title + ": " + e.getMessage());
			}
		}
		else
			System.out.println("Empty File!");

		return "postImages";
	}
}