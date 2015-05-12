jquery(document).ready(function() {
	var images = [];

	jquery.get("http://localhost:8080/getImages")
		.done(function(data) {
			for (var i = 0; i < data.length; i++) {
				var image = new Object();

				image.title = data[i].title;
				image.description = data[i].description;
				image.filename = data[i].filename;
				render(image);
				images.push(image);
			}
		})

})

function render(image) {
	var openContainer = "<div class='container'>";
	var imageTitle = "<h3 class='img-header'" + image.title + "</h3>";
	var imageFile = "img class='img-content' src='" + image.filename + "'/>";
	var imageDescription = "<p class='img-description'>" + image.description + "</p>"
	var closeContainer = "</div>";

	jquery("main").append(openContainer);
	jquery("main").append(imageTitle);
	jquery("main").append(imageFile);
	jquery("main").append(imageDescription);
	jquery("main").append(closeContainer);
}