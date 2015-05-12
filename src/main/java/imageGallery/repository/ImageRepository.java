package imageGallery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("imageRepository")
public interface ImageRepository extends JpaRepository<Image, Long> {

}