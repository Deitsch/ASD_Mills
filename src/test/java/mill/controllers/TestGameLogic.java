package mill.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mill.model.Gamefield;
import mill.model.Node;
import mill.model.Token;

class TestGameLogic {
	public static Gamefield gamefield = new Gamefield(false, 1);

	@BeforeEach
	void setUp()  {
		
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
	
	@Test 
	void testCheckGamefieldRowAndColumn() {
		assertEquals(3, Gamefield.getGamefieldRows());
		assertEquals(8, Gamefield.getGamefieldColumns());	
	}
	
	@Test
	void testInitNode() {
		int row;
		int column;
		int id = 1;
		for(row = 0 ; row < 3; row ++) {
			for(column = 0; column < 8 ; column++) {
		Node node = Gamefield.getNode(row , column);
		assertNotNull(node);
		assertEquals(Token.EMPTY ,node.getToken());
		assertEquals("f"+ id, node.getID() );
		id++;
			}
		}
	}
	
	@Test
	void testCheckMill() {
		fail("Not yet implemented");
	}
	
	@Test
	void testIsMill() {
		
	}

}
