package mill.model;

public class Gamefield {

	public Node[][] gamefield = new Node [3][8];

	public Gamefield () { }

	public Node getNode(int column, int row) {
		return gamefield[row][column];
	}

	public Node getNodeByID(String id){
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

	public Node[][] setGameField(Node field, int spielfeldZeile, int spielfeldSpalte) {
		gamefield[spielfeldZeile][spielfeldSpalte]= field;
		return gamefield;
	}

	public void printGameField(){
		for (int zeile = 0; zeile < gamefield.length; zeile++ )
		{
			System.out.print("Zeile " + zeile + ": ");
			for ( int spalte=0; spalte < gamefield[zeile].length; spalte++ )
				System.out.print( gamefield[zeile][spalte].getToken() + " ");
			System.out.println();
		}

		//System.out.println(gamefield.length);
	}

	public int getGamefieldColumns() {
		return gamefield[0].length;
	}

	public int getGamefieldRows() {
		return gamefield.length;
	}
}
