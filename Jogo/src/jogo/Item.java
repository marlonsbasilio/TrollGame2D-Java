package jogo;

import jplay.Sprite;

public class Item extends Sprite{

	public Item(String fileName, int numFrames) {
		super(fileName, numFrames);
		// TODO Auto-generated constructor stub
	}
	
	public void PickUp(Jogador jogador) {
		if (jogador.getMochila().size() + jogador.keyhave < 5) {
			if ((jogador.x >= this.x -30 && jogador.x <= this.x +30) && (jogador.y >= this.y -30 && jogador.y <= this.y +30)) {
				if (this instanceof Potion) {
					jogador.getMochila().add(this);
					this.x = 10000;
				}
				else {
					jogador.keyhave = 1;
				}
				this.x = 10000;
			}
		}
	}
}
