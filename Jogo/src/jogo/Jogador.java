package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Jogador extends Criatura {
	
	private LinkedList<Item> mochila = new LinkedList<Item>();
	public int id_sala;
	public double gold = 0;
	public int diamante = 0;
	public int keyhave = 0;

	public Cenario1 c1 = null;
	public Cenario2 c2 = null;
	public Cenario3 c3 = null;
	public Cenario4 c4 = null;
	public Cenario5 c5 = null;
	public Cenario6 c6 = null;
	public Cenario7 c7 = null;
	public Cenario8 c8 = null;
	public Cenario9 c9 = null;
	public Cenario10 c10 = null;
	public Cenario11 c11 = null;
	public Cenario12 c12 = null;
	public Cenario13 c13 = null;
	public Cenario14 c14 = null;
	public Cenario15 c15 = null;
	public Cenario16 c16 = null;
	public Cenario17 c17 = null;
	public Cenario18 c18 = null;
	public Cenario19 c19 = null;
	public Cenario20 c20 = null;
	
	public Jogador(int x, int y, Window window) {
        //Esse construtor é da classe Sprite que é a super classe da classe Jogador
		super(URL.sprite("frames.png"),36);
		
        //Essas variáveis são da classe GameObject que é uma super classe de Sprite.
		this.x = x;
		this.y = y;
		this.setTotalDuration(3000);
		// Vida total do personagem
		this.vida = 25;
		c1 = new Cenario1(window, this);
		c2 = new Cenario2(window, this);
		c3 = new Cenario3(window, this);
		c4 = new Cenario4(window, this);
		c5 = new Cenario5(window, this);
		c6 = new Cenario6(window, this);
		c7 = new Cenario7(window, this);
		c8 = new Cenario8(window, this);
		c9 = new Cenario9(window, this);
		c10 = new Cenario10(window, this);
		c11 = new Cenario11(window, this);
		c12 = new Cenario12(window, this);
		c13 = new Cenario13(window, this);
		c14 = new Cenario14(window, this);
		c15 = new Cenario15(window, this);
		c16 = new Cenario16(window, this);
		c17 = new Cenario17(window, this);
		c18 = new Cenario18(window, this);
		c19 = new Cenario19(window, this);
		c20 = new Cenario20(window, this);
		id_sala = 1;
		c1.run();
	}
	
	ControleAtirar machado = new ControleAtirar();
	
	public void atirar(Window janela, Scene cena, Keyboard teclado, Criatura troll) {
		if ( teclado.keyDown(KeyEvent.VK_A)) {
			machado.Addmachado(x +5, y+20, direcao, cena);
		}
		machado.run(troll);
			
	}
	
	public void potion_use(Keyboard teclado) {
		if (teclado.keyDown(KeyEvent.VK_S)) {
			for (int i = 0, trigger = 0; i < this.mochila.size() && trigger == 0; i++) {
				if (this.mochila.get(i) instanceof Potion) {
					this.mochila.remove(i);
					this.vida += 10;
					if (this.vida > 25) {
						this.vida = 25;
					}
					trigger = 1;
				}
			}
		}
	}
	
	public void controle(Window janela, Keyboard teclado) {
		if (teclado.keyDown(Keyboard.LEFT_KEY)) {
			if ( this.x > 0) {
				this.x -= velocidade;
			}
			if ( direcao != 1) {
				setSequence(9,18);
				direcao = 1;
			}
			movendo = true;
		}
		else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
			if ( this.x < janela.getWidth() - 60) {
				this.x += velocidade;
			}
			if ( direcao != 2) {
				setSequence(27,36);
				direcao = 2;
			}
			movendo = true;
		}		
		else if (teclado.keyDown(Keyboard.UP_KEY)) {
			if ( this.y > 0) {
				this.y -= velocidade;
			}
			if ( direcao != 4) {
				setSequence(0, 9);
				direcao = 4;
			}
			movendo = true;
		}
		else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
			if ( this.y < janela.getHeight() - 60) {
				this.y += velocidade;
			}	
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
	
	Font f = new Font("arial", Font.BOLD,20);
	
	public void vida(Window janela) {
		janela.drawText("VIDA: " + ((int)this.vida), 30, 30, Color.RED,f);
		janela.drawText("Sala: " + this.id_sala, 350, 30, Color.WHITE,f);
		janela.drawText("Ouro: " + ((int)this.gold), 30, 90, Color.YELLOW,f);
		janela.drawText("Diamante: " + this.diamante , 30, 110, Color.GRAY,f);
		int i = this.keyhave;
		janela.drawText("Chave: " + i, 30, 190, Color.WHITE,f);
		for (i = 0; i < this.mochila.size();) {
			if (this.mochila.get(i) instanceof Potion) {
				i++;
			}
		}
		janela.drawText("Mochila: " + (this.mochila.size() + this.keyhave) , 30, 150, Color.WHITE,f);
		janela.drawText("Poções: " + i , 30, 170, Color.WHITE,f);
	}

	public LinkedList<Item> getMochila() {
		return mochila;
	}

	public void setMochila(LinkedList<Item> mochila) {
		this.mochila = mochila;
	}	
}