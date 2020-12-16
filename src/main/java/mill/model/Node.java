package mill.model;

public class Node {
	private Token token;
	private int row;
	private int column;
	public String id;
	private Boolean selected = false;
	private Boolean inCorner = false;
	
	public Node(Token token, int row, int column, String id, Boolean selected, Boolean inCorner) {
		this.setRow(row);
		this.setColumn(column);
		this.setToken(token);
		this.setId(id);
		this.setInCorner(inCorner);
		this.setSelected(selected);
	}

	// Setter Method
	private void setInCorner(Boolean inCorner) {
		// TODO Auto-generated method stub
		this.inCorner=inCorner;
	}


	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id=id;
	}


	public void setColumn(int column) {
		// TODO Auto-generated method stub
		this.column=column;
	}


	public void setRow(int row) {
		// TODO Auto-generated method stub
		this.row=row;
	}


	public void setToken(Token token) {
		// TODO Auto-generated method stub
		this.token=token;
	}

	// Getter Method
	public Token getToken(){
		return this.token;
	}

	public String getID() {
		return this.id;
	}

	public Boolean isSelected() {
		return selected;
	}

	public Boolean getInCorner() {
		return this.inCorner;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}


	@Override
	public String toString(){

		return  "Feld mit der ID: "	+this.id
				+" ist in Ecke " +this.inCorner
				+"\nENDE\n\n";
	}
		
}
