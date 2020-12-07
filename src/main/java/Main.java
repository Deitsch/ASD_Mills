 

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import mill.Constants;


public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {

		final Image ImageBackground = new Image(Constants.IMAGE_BACK_PNG);

		final BackgroundSize backgroundSize = new BackgroundSize(800, 650, false, false, false, false);
	    final BackgroundImage backgroundImage = new BackgroundImage(ImageBackground, BackgroundRepeat.REPEAT, 
	            BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
	    final Background background = new Background(backgroundImage);
	    
		try {
			Pane root = FXMLLoader.load(getClass().getResource("Board.fxml"));

			Scene scene = new Scene(root);
			root.setBackground(background);
			primaryStage.setTitle(Constants.NAME_MILL);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(Main.class);

	}
}
