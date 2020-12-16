package mill.model;
import javafx.scene.image.Image;

public class Figure {
    public Image image;
    public Image selectedImage;

    Figure(Image image, Image selectedImage) {
        this.image = image;
        this.selectedImage = selectedImage;
    }
}
