package jogo;

import jplay.Sprite;
import jplay.URL;

public class Diamante extends Sprite {

	public Diamante(int x, int y) {
		super(URL.sprite("diamante.png"),1);
		this.x = x;
		this.y = y;
		this.setTotalDuration(500);
	}
	public int quantidade = 1;
	
	public void Steal(Jogador jogador) {
		if ((jogador.x >= this.x -30 && jogador.x <= this.x +30) && (jogador.y >= this.y -30 && jogador.y <= this.y +30)) {
		jogador.diamante += quantidade;
		this.x = 10000;
		}
		
	}
}