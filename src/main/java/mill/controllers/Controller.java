package mill.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;
import mill.model.*;
import mill.controllers.*;

public class Controller implements Initializable, EventHandler<MouseEvent> {

	private static final Image BLACK = new Image("black.png", 50, 50, true, true);
	private static final Image SELECTED_BLACK = new Image("black_green.png", 50, 50, true, true);
	private static final Image WHITE = new Image("white.png", 50, 50, true, true);
	private static final Image SELECTED_WHITE = new Image("white_green.png", 50, 50, true, true);

	private static final Image INFO = new Image("info.png", 50, 50, true, true);
	public static Player player_white = new Player("Manuel", "white", true);
	public static Player player_black = new Player("Übeyd", "black", false);
	public static String player = "white";
	public static Gamefield gamefield = new Gamefield(false, 1);
	public GameHandler gameHandler = new GameHandler();
	public VBox v1;
	public VBox v2;
	public Label lbl_title;
	public Label lbl_white;
	public Label lbl_black;
	public Node node;
	public ImageView f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21,
			f22, f23, f24;
	public ImageView lbl_info;
	public Pane outerPane;
	public MenuBar bar_menu;

	public void startGame(ActionEvent event) {

		for (int i = 1; i < 25; i++) {
			ImageView f = (ImageView) outerPane.lookup("#f" + i);
			f.setImage(null);
		}

		v1.getChildren().clear();
		v2.getChildren().clear();

		// Player 1
		for (int i = 0; i < 9; i++) {
			ImageView view = new ImageView(WHITE);
			v1.getChildren().add(view);
			lbl_white.setVisible(true);
		}
		// Player 2
		for (int i = 0; i < 9; i++) {
			ImageView view = new ImageView(BLACK);
			v2.getChildren().add(view);
			lbl_black.setVisible(true);
		}

		int i = 0;
		for (int spielfeldZeile = 0; spielfeldZeile < 3; spielfeldZeile++) {
			for (int spielfeldSpalte = 0; spielfeldSpalte < 8; spielfeldSpalte++) {
				i++;
				String id;
				boolean inCorner = true;
				if (i % 2 != 0) {
					inCorner = true;
				} else {
					inCorner = false;
				}
				id = "f" + Integer.toString(i);
				Node node = new Node(Token.EMPTY, spielfeldZeile, spielfeldSpalte, id, false, inCorner);
				gamefield.setGameField(node, spielfeldZeile, spielfeldSpalte);
				// System.out.println(node.getID());
			}
		}
		gamefield.gameStarted = true;

	}

	public void initialize(URL location, ResourceBundle resources) {

		lbl_info.setImage(INFO);
	}

	// setToken wird durch ein MouseEvent aufgerufen
	public void setToken(MouseEvent event) {

		if (!gamefield.getGameStarted()) {
			feedback("Start a new Game!");
		} else {
			ImageView f = (ImageView) event.getSource();
			String nodeId = f.getId();

			if (gamefield.gamePhase == 1) {
				setToken_phase1(event);
			}

			else if (gamefield.gamePhase == 2) {
				setToken_phase2(event);
			}
		}

	}

	private void setToken_phase1(MouseEvent event) {
		ImageView f = (ImageView) event.getSource();
		String nodeId = f.getId();

		if (f.getImage() == null) {
			switch (player) {
			case "white":
				gamefield.getNode(nodeId).setToken(Token.WHITE);
				f.setImage(WHITE);
				v1.getChildren().remove(v1.getChildren().size() - 1);

				if (GameHandler.checkMill(gamefield.getNode(nodeId), gamefield)) {
					// TO DO
					// System.out.println("Test: " + gamefield.getNode(nodeId));
					// Handle click on empty field, own field, opponents field
					// Handle View and Gamefield Object !
				}

				GameHandler.changePlayer();
				GameHandler.checkAndChangeGamePhase(v1, v2);
				break;

			case "black":
				gamefield.getNode(nodeId).setToken(Token.BLACK);
				;
				f.setImage(BLACK);
				v2.getChildren().remove(v2.getChildren().size() - 1);

				if (GameHandler.checkMill(gamefield.getNode(nodeId), gamefield)) {
					// TO DO
					// Handle click on empty field, own field, opponents field
					// Handle View and Gamefield Object !

				}

				GameHandler.changePlayer();
				GameHandler.checkAndChangeGamePhase(v1, v2);
			}
		} else {
			feedback("An dieser Stelle ist bereits ein Spielstein vorhanden");
			System.out.println("Log: Hier ist bereits ein Spielstein vorhanden");
		}
	}

	private void setToken_phase2(MouseEvent event) {
		ImageView f = (ImageView) event.getSource();
		String nodeId = f.getId();

		if (!gamefield.getNode(nodeId).getSelected()) {
			for (int i = 1; i <= 24; i++) {

				gamefield.getNode("f" + Integer.toString(i)).setSelected(false);
			}
			gamefield.getNode(nodeId).setSelected(true);
		}
		if (gamefield.getNode(nodeId).getToken() != Token.EMPTY) {
			switch (player) {
			case "white":
				f.setImage(SELECTED_WHITE);
				break;
			case "black":
				f.setImage(SELECTED_BLACK);
				break;
			}
		}
	}

	public void feedback(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Nine Men's Morris");
		alert.setHeaderText(message);
		alert.showAndWait();

	}

	public void showRules(ActionEvent event) {
		gameHandler.messageBox("Nine Men's Morris", "Game Rules", "Define Rules here");
	}

	public void showRulesFromInfo(MouseEvent event) {
		gameHandler.messageBox("Nine Men's Morris", "Game Rules", "Define Rules here");
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
