package mill.model;

import javafx.scene.image.Image;

public class Player {
	
	public String name; 
	public MillsColors color;
	private Figure figure;

	public Player(String name, MillsColors color) {
		this.name = name;
		this.color = color;
		setupFigure(color);
	}

	public Figure getFigure() {
		return figure;
	}

	private void setupFigure(MillsColors color) {
		Image image;
		Image imageSelected;
		switch(color) {
			case black:
				image = new Image("black.png", 50, 50, true, true);
				imageSelected = new Image("black_green.png", 50, 50, true, true);
				break;
			case white:
				image = new Image("white.png", 50, 50, true, true);
				imageSelected = new Image("white_green.png", 50, 50, true, true);
				break;
			default:
				throw new IllegalStateException("All enum cases have to be handled here");
		}
		this.figure = new Figure(image, imageSelected);
	}
}
