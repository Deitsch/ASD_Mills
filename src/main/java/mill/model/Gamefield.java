package mill.model;

public class Gamefield {

	private Node[][] gamefield = new Node [3][8];

	public Gamefield () { }

	public Node getNode(int column, int row) {
		return gamefield[row][column];
	}

	public Node getNodeByID(String id){
		Integer gameFieldRows = getGamefieldRows();
		Integer gameFieldColumns = getGamefieldColumns();
		Node field;

		for (int row = 0; row < gameFieldRows; row++ ){
			for (int column=0; column < gameFieldColumns; column++){
				field=gamefield[row][column];
				if(id.equalsIgnoreCase(field.getID())) {
					return field;
				}
			}
		}
		return null;
	}

	public Node[][] setNode(Node node, int row, int column) {
		gamefield[row][column] = node;
		return gamefield;
	}

	public void printGameField(){
		Integer gameFieldRows = getGamefieldRows();
		Integer gameFieldColumns = getGamefieldColumns();

		for (int row = 0; row < gameFieldRows; row++)
		{
			System.out.print("Zeile " + row + ": ");
			for (int column = 0; column < gameFieldColumns; column++)
				System.out.print(gamefield[row][column].getToken() + " ");
			System.out.println();
		}
	}

	public int getGamefieldColumns() {
		return gamefield[0].length;
	}

	public int getGamefieldRows() {
		return gamefield.length;
	}
}
