package jogo;

import jplay.Sprite;
import jplay.URL;

public class Atirar extends Sprite{

	public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;	
	
	protected static final double velocidade_tiro = 0.3;
	protected int caminho = STOP;
	protected boolean movendo = false;
	protected int direcao = 3;

	
	
	public Atirar(double x, double y, int caminho) {
		super(URL.sprite("machado.png"),16);
		this.caminho = caminho;
		this.x = x;
		this.y = y;
	}	
	public void mover() {
		if ( caminho == LEFT) {
			this.x -= velocidade_tiro;
			if ( direcao != 1) {
				setSequence(12,16);
				direcao = 1;
			}
			movendo = true;
		}
		else if (caminho == RIGHT) {
				this.x += velocidade_tiro;
			if ( direcao != 2) {
				setSequence(8, 12);
				direcao = 2;
			}
			movendo = true;
		}		
		else if ( caminho == UP) {
				this.y -= velocidade_tiro;
			if ( direcao != 4) {
				setSequence(4, 8);
				direcao = 4;
			}
			movendo = true;
		}
		else if ( caminho == DOWN) {
				this.y += velocidade_tiro;
			if ( direcao != 5) {
				setSequence(0, 4);
				direcao = 5;
			}
			movendo = true;
		}
		
		if (movendo) {
			update();
			movendo = false;
		}
	}
}
