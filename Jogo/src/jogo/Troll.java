package jogo;

import javax.swing.JOptionPane;

import jplay.URL;

public class Troll extends Criatura{

	private double ataque = 0.005;
		
	public Troll(int x, int y) {
		super(URL.sprite("Trollframes.png"), 36);
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.setTotalDuration(4000);
		this.velocidade = 0.1;
		this.vida = 300;
	}
	
	ControleAtirar machado = new ControleAtirar();
	
	public void perseguir(double x, double y) {
		
		if ( this.x > x && this.y <= y+50 && this.y >= -50) {
			moveTo(x, y, velocidade);
			if ( direcao != 1) {
				setSequence(9,18);
				direcao = 1;				
			}
			movendo = true;
		}
		else if (this.x < x && this.y <= y +50 && this.y >= -50) {
			moveTo(x, y, velocidade);
			if ( direcao != 2) {
				setSequence(27,36);
				direcao = 2;				
			}
			movendo = true;
		}
		else if (this.y > y) {
			moveTo(x, y, velocidade);
			if ( direcao != 4) {
				setSequence(0,9);
				direcao = 4;				
			}
			movendo = true;
		}
		else if (this.y < y) {
			moveTo(x, y, velocidade);
			if ( direcao != 5) {
				setSequence(18,27);
				direcao = 5;				
			}
			movendo = true;
		}
		if (movendo) {
			update();
			movendo = false;
		}
	}


	public void morrer() {
	
		if (this.vida <= 0) {
			this.velocidade = 0;
			this.ataque = 0;
			this.direcao = 0;
			this.movendo = false;
			this.x = 100000;
		}
	}
	public void atacar(Jogador jogador) {
		if (this.collided(jogador)) {
			jogador.vida -= this.ataque;
			jogador.gold -= 0.003;
		}
		if (jogador.vida <= 0) {
			JOptionPane.showMessageDialog(null, "Voce Morreu !");
			System.exit(0);
		}
	}
}
