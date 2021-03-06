package mill.controllers;

import mill.model.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void checkToken_Empty() {
        Token token = Token.EMPTY;
        boolean actual = GameHandler.checkToken(token);
        assertTrue(actual);
    }

    @Test
    void checkToken_Black() {
        Token token = Token.BLACK;
        boolean actual = GameHandler.checkToken(token);
        assertFalse(actual);
    }
    
    @Test
    void checkToken_White() {
        Token token = Token.WHITE;
        boolean actual = GameHandler.checkToken(token);
        assertFalse(actual);
    }
}