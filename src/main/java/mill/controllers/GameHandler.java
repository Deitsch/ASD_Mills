package mill.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import mill.controllers.*;
import mill.model.*;

public class GameHandler {

	public static void changePlayer() {

		if (Controller.player_white.isTurn) {
			Controller.player_white.setIsTurn(false);
			Controller.player = Controller.player_black.color;
			Controller.player_black.setIsTurn(true);
		} else {
			Controller.player_white.setIsTurn(true);
			Controller.player = Controller.player_white.color;
			Controller.player_black.setIsTurn(false);
		}
	}

	public static void checkAndChangeGamePhase(VBox v1, VBox v2) {

		if ((v1.getChildren().size() <= 0) && (v2.getChildren().size() <= 0)
				&& (Controller.gamefield.getGamePhase() == 1)) {
			Controller.gamefield.setGamePhase(2);

		}
	}

	public static void messageBox(String title, String header, String text) {
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(text);
		alert.showAndWait();

	}


	public static Boolean checkMill(Node token, Gamefield gamefield) {
		Node token_1 = null;
		Node token_2 = null;
		Node token_3 = null;
		int row = token.getRow();
		int column = token.getColumn();

		if (token.getInCorner()) { // Check if Node is in a Corner
			switch (column) {
			case 0: // If Node is on the first Position
				token_2 = gamefield.getNode(6, token.getRow());
				token_3 = gamefield.getNode(7, token.getRow());
				if (isMill(token, token_2, token_3)) {
					System.out.println("MILL");
					return true;
				} else {
					token_2 = gamefield.getNode(1, token.getRow());
					token_3 = gamefield.getNode(2, token.getRow());
					if (isMill(token, token_2, token_3)) {
						System.out.println("MILL");
						return true;
					} else {
						break;
					}
				}

			case 6: // If Node is on the second-last Position
				token_2 = gamefield.getNode(7, token.getRow());
				token_3 = gamefield.getNode(0, token.getRow());
				if (isMill(token, token_2, token_3)) {
					System.out.println("MILL");
					return true;
				} else {
					token_2 = gamefield.getNode(5, token.getRow());
					token_3 = gamefield.getNode(4, token.getRow());
					if (isMill(token, token_2, token_3)) {
						System.out.println("MILL");
						return true;
					} else {
						break;
					}
				}

			default:
				token_2 = gamefield.getNode(token.getColumn() - 1, token.getRow());
				token_3 = gamefield.getNode(token.getColumn() - 2, token.getRow());
				if (isMill(token, token_2, token_3)) {
					System.out.println("MILL");
					return true;
				} else {
					token_2 = gamefield.getNode(token.getColumn() + 1, token.getRow());
					token_3 = gamefield.getNode(token.getColumn() + 2, token.getRow());
					if (isMill(token, token_2, token_3)) {
						System.out.println("MILL");
						return true;
					} else {
						System.out.println("NO MILL");
						break;
					}
				}
			}
		} else {
			
			switch (column) {
			case 7://check last Row
				token_1 = gamefield.getNode(column, row);
				token_2 = gamefield.getNode(column-1, row);
				token_3 = gamefield.getNode(0, row);
				break;
				
			default: //check normal row
				token_1 = gamefield.getNode(column, row);
				token_2 = gamefield.getNode(column-1, row);
				token_3 = gamefield.getNode(column+1, row);
				break;
			}
			if (isMill(token_1, token_2, token_3)) {
				System.out.println("MILL");
				return true;
			} else {//check column
				token_1 = gamefield.getNode(column, 0);
				token_2 = gamefield.getNode(column, 1);
				token_3 = gamefield.getNode(column, 2);
				if (isMill(token_1, token_2, token_3)) {
					System.out.println("MILL");
					return true;
				} else {
					return false;
				}								
			}			
		}
		return false;
	}
	

	private static Boolean checkMillMiddle(Node token) {
		// TODO
		return true;
	}

	public static boolean isMill(Node token, Node token_2, Node token_3) {
		return token.getToken().equals(token_2.getToken()) && token.getToken().equals(token_3.getToken());
	}

	public static boolean checkToken(Token token) {
		// TODO Auto-generated method stub
		return false;
	}
}
