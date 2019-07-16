package jogo;

import jplay.URL;

public class Key extends Item {

	public Key(double x, double y) {
		super(URL.sprite("key.png"), 1);
		this.x = x;
		this.y = y;
		this.setTotalDuration(500);
	}
}
