package mill.model;

public class Player {
	
	public String name; 
	public String color;
	public Boolean isTurn;

	
	public Player(String name, String color, Boolean isTurn) {
		this.setName(name);
		this.setColor(color);
		this.setIsTurn(isTurn);
		
	}
	
	public Player (String name) {
		this.setName(name);
	}

	private void setColor(String color) {
		this.color=color;
	}

	private void setName(String name) {
		this.name=name;
	}

	
	//Gettermethoden
		public String getName(){
			return this.name;
		}
		public String getColor(){
			return this.color;
		}

		
		public Boolean getIsTurn() {
			return isTurn;
		}

		public void setIsTurn(Boolean isTurn) {
			this.isTurn = isTurn;
		}

		@Override
		public String toString(){
			
			return  "Der Spieler heißt: " +this.name				
					//+"\nBeginnt das Spiel: "+this.beginner
					//+"\nist am Zug: "+this.spielen
					+"\nund hat die Farbe: "+this.color
					+"\nENDE\n\n";
		}
	
	
	
	

}
