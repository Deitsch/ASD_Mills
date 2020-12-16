package mill.controllers;

import javafx.scene.image.Image;
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

    public Player player_white;
    public Player player_black;
    public Player activePlayer;

    private Gamefield gamefield;
    public GamePhase gamePhase;

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
                && (gamePhase == GamePhase.setting)) {
            this.gamePhase = GamePhase.moving;
        }
    }

    public void setTokenForCurrentPlayer(String nodeId) {
        gamefield.getNodeByID(nodeId).setToken(activePlayer.token);
    }

    public void selectNode(String nodeId) {
        deselectAllNodes();
        gamefield.getNodeByID(nodeId).setSelected(true);
    }

    private void deselectAllNodes() {
        for (int i = 1; i < Constants.MAX_FIELDS; i++) {
            gamefield.getNodeByID("f" + i).setSelected(false);
        }
    }

    public Image moveToken(String nodeId) {
        Node node = gamefield.getNodeByID(nodeId);

        if (node.getToken() != Token.EMPTY) {
            selectNode(nodeId);
            return activePlayer.getFigure().selectedImage;
        }
        throw new IllegalStateException("Moving token illegally is not handled yet");
    }

    public void resetGameField() {
        int i = 0;
        for (int row = 0; row < Constants.boardRows; row++) {
            for (int column = 0; column < Constants.boardColumns; column++) {
                i++;
                boolean inCorner = (i % 2 != 0);
                Node node = new Node(Token.EMPTY, row, column, "f" + i, false, inCorner);
                gamefield.setNode(node, row, column);
            }
        }
    }
}
