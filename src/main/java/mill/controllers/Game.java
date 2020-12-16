package mill.controllers;

import javafx.scene.layout.VBox;
import mill.Constants;
import mill.model.Gamefield;
import mill.model.Node;
import mill.model.Player;
import mill.model.Token;

enum GamePhase {
    notStarted,
    setting,
    moving
}

public class Game {

    Player player_white;
    Player player_black;

    public Player activePlayer;

    Gamefield gamefield;

    GamePhase gamePhase;

    Game(Player white, Player black) {
        this.player_white = white;
        this.player_black = black;

        gamePhase = GamePhase.notStarted;
        gamefield = new Gamefield();
    }

    public void changeActivePlayer() {
        this.activePlayer = activePlayer == player_black
                ? player_white
                : player_black;
    }

    public void checkAndChangeGamePhase(VBox v1, VBox v2) {
        if (v1.getChildren().isEmpty() && v2.getChildren().isEmpty()
                && (Controller.gamefield.getGamePhase() == 1)) {
            this.gamePhase = GamePhase.moving;
        }
    }

    public void setTokenForCurrentPlayer(String nodeId) {
        Token token;
        switch (activePlayer.color) {
            case white:
                token = Token.WHITE;
            case black:
                token = Token.BLACK;
            default:
                token = Token.EMPTY;
        }
        gamefield.getNodeByID(nodeId).setToken(token);
    }

    public void resetGameField() {
        int i = 0;
        for (int spielfeldZeile = 0; spielfeldZeile < Constants.boardRows; spielfeldZeile++) {
            for (int spielfeldSpalte = 0; spielfeldSpalte < Constants.boardColumns; spielfeldSpalte++) {
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
    }
}
