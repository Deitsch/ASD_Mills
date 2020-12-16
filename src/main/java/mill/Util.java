package mill;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class Util {

    public static void showAlert(String title, String header, String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public static final Image INFO = new Image("info.png", 50, 50, true, true);
}
