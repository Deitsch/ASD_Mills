package mill.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

import mill.Constants;
import mill.Util;
import mill.model.*;


public class Controller implements Initializable, EventHandler<MouseEvent> {

	public VBox bench_white, bench_black;
	public Label lbl_title, lbl_white, lbl_black;
	public Node node;
	public ImageView f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21,
			f22, f23, f24;
	public ImageView lbl_info;
	public Pane outerPane;
	public MenuBar bar_menu;

	private Game game;

	Controller() {
		Player player_white = new Player("Bobo", MillsColors.white);
		Player player_black = new Player("Maddin", MillsColors.black);

		this.game = new Game(player_white, player_black);
	}

	private void resetGameUI() {
		for (int i = 1; i < Constants.MAX_FIELDS; i++) {
			ImageView f = (ImageView) outerPane.lookup("#f" + i);
			f.setImage(null);
		}
	}

	public void startGame(ActionEvent event) {
		resetGameUI();

		resetBench(bench_white, game.player_white);
		resetBench(bench_black, game.player_black);

		game.gamePhase = GamePhase.setting;
	}

	private void resetBench(VBox bench, Player player) {
		bench.getChildren().clear();
		for (int i = 0; i < 9; i++) {
			ImageView view = new ImageView(player.getFigure().image);
			bench.getChildren().add(view);
			lbl_black.setVisible(true);
		}
	}

	public void initialize(URL location, ResourceBundle resources) {
		lbl_info.setImage(Util.INFO);
	}

	// setToken wird durch ein MouseEvent aufgerufen
	public void setToken(MouseEvent event) {
		switch (game.gamePhase) {
			case notStarted:
				Util.showAlert("Nine Men's Morris", "Start a new Game!", "");
				break;
			case setting:
				setToken_phase1(event);
				break;
			case moving:
				setToken_phase2(event);
				break;
		}
	}


	private void setToken_phase1(MouseEvent event) {
		ImageView field = (ImageView) event.getSource();
		String nodeId = field.getId();

		if (field.getImage() != null) {
			Util.showAlert("Error", "An dieser Stelle ist bereits ein Spielstein vorhanden", "");
			System.out.println("Log: Hier ist bereits ein Spielstein vorhanden");
			return;
		}

		game.setTokenForCurrentPlayer(nodeId);

		if (game.activePlayer.color == MillsColors.white) {
			reduceBench(bench_white);
		} else {
			reduceBench(bench_black);
		}

		game.checkAndChangeGamePhase(bench_white, bench_black);
		game.changeActivePlayer();
	}

	private void reduceBench(VBox bench) {
		bench.getChildren().remove(bench.getChildren().size() - 1);
	}

	private void setToken_phase2(MouseEvent event) {
		ImageView field = (ImageView) event.getSource();
		String nodeId = field.getId();

		if (!gamefield.getNode(nodeId).getSelected()) {
			for (int i = 1; i <= 24; i++) {

				gamefield.getNode("f" + Integer.toString(i)).setSelected(false);
			}
			gamefield.getNode(nodeId).setSelected(true);
		}
		if (gamefield.getNode(nodeId).getToken() != Token.EMPTY) {
			switch (player) {
			case "white":
				field.setImage(SELECTED_WHITE);
				break;
			case "black":
				field.setImage(SELECTED_BLACK);
				break;
			}
		}
	}

	// TODO: Fix if these are in fact the same -> remove one!
	public void showRules(ActionEvent event) {
		Util.showAlert("Nine Men's Morris", "Game Rules", "Define Rules here");
	}

	public void showRulesFromInfo(MouseEvent event) {
		Util.showAlert("Nine Men's Morris", "Game Rules", "Define Rules here");
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
