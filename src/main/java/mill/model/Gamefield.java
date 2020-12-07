package mill.model;

public class Gamefield {
	
	
	public Boolean gameStarted = false;	//Definiet ob das Spiel gestartet wurde oder nicht
	public int gamePhase = 1;	//Definiert die zwei Phasen des Spiels (Phase 1: Setzten der Tokens; Phase 2: Spielen)
	
	public static Node [] [] gamefield = new Node [3] [8];

	
	public Gamefield (Boolean gameStarted,int startphase) {		
		this.setGameStarted(gameStarted);
		this.setGamePhase(startphase);
		

	}
	
	//Setter-Methoden
	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
		
	}
	
	public void setGamePhase(int startphase) {	
		this.gamePhase = startphase;
	}
	
	public Node[][] setGameField(Node field, int spielfeldZeile, int spielfeldSpalte) {
		gamefield[spielfeldZeile][spielfeldSpalte]= field;	
		return gamefield;
	}
	
	//Getter-Methoden
	public Boolean getGameStarted() {
		return gameStarted;
	}
	
	public int getGamePhase() {
		return gamePhase;
	}
	
	public Node getNode(String id){ 
		Node field = null;
		
		for (int zeile = 0; zeile < gamefield.length; zeile++ ){
			for (int spalte=0; spalte < gamefield[zeile].length; spalte++){
				
				field=gamefield[zeile][spalte];
				//System.out.println(field.getID());
				//System.out.println(field);
	      		//System.out.println("Vergleich ID: " + id + " mit Feld ID " + field.getID());
	      		
	      		if(id.equalsIgnoreCase(field.getID())) {
	    		  return field;
		    	 }
		    	 else {
		    		 //System.out.println("Log: Feld wurde nicht gefunden");
		    	 }
			}
	    }
		return null;
	}
	
	public static Node getNode(int column, int row) {
		Node field = null;
		field=gamefield[row][column];		
		return field;
		
	}
	
	/*
	public void setGameStarted(Boolean gameStarted) {
		this.gameStarted = gameStarted;
	}*/
	
	public static void getGameField(){
		for (int zeile = 0; zeile < gamefield.length; zeile++ )
	    {
	      System.out.print("Zeile " + zeile + ": ");
	      for ( int spalte=0; spalte < gamefield[zeile].length; spalte++ )
	        System.out.print( gamefield[zeile][spalte].getToken() + " ");
	      	System.out.println();
	    }
		
		//System.out.println(gamefield.length);
	}
	
	public static int getGamefieldColumns() {
		return gamefield[gamefield.length-1].length;
	}
	
	public static int getGamefieldRows() {
		return gamefield.length;
	}
		
	
	@Override
	public String toString(){
		
		return  "Gamefield: "				
				+"\ngameStarted: "+this.gameStarted
				+"\nstartphase: "+this.gamePhase
				+"\nENDE\n\n";
	}

}
