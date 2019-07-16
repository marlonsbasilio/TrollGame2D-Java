package jogo;

import jplay.URL;

public class Potion extends Item{

	public Potion(int x, int y) {
		super (URL.sprite("potion-life.png"),1);
		this.x = x;
		this.y = y;
		this.setTotalDuration(500);
	}
}
