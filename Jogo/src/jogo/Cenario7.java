package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;


public class Cenario7 extends Cenario{
	
	private Window janela;
	private Scene cena;
	private Jogador jogador = null;
	private Keyboard teclado;
	private Troll troll[];
	private boolean access = false;
	private Ouro ouro;
	
	public Cenario7 (Window window, Jogador player) {
		
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario3_5_7.scn"));
		jogador = player;
		teclado = janela.getKeyboard();
		troll = new Troll[1];
		ouro = new Ouro(480,350);
	}
	public void run() {
		
		if (access == false) {
			for (int i = 0; i < troll.length; i++) {
				troll[i] = new Troll(300 + (1 + (i*50)), 200 + (1 + (i*20)));
			}
			access = true;
		}
		
		while(true) {
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
//			cena.draw();
			cena.moveScene(jogador);
			jogador.vida(janela);
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			jogador.draw();
			ouro.x += cena.getXOffset();
			ouro.y += cena.getYOffset();
			ouro.draw();
			jogador.potion_use(teclado);
			int cont = 0;

			for (int i = 0; i < troll.length; i++) {
				if (troll[i].vida <= 0) {
					cont++;
				}
			}
			if (cont == troll.length) {
			ouro.Steal(jogador);
			}
			
			for (int i = 0; i < troll.length; i++) {
			troll[i].atacar(jogador);
			troll[i].caminho(cena);
			troll[i].perseguir(jogador.x, jogador.y);
			troll[i].x += cena.getXOffset();
			troll[i].y += cena.getYOffset();
			jogador.atirar(janela, cena, teclado, troll[i]);
			troll[i].morrer();
			troll[i].draw();			
			}
			janela.update();
			mudarCenario();
		}
	}
	private void mudarCenario() {
		if (tileCollision(2, jogador, cena) == true) {
			jogador.x = 380;
			jogador.y = 240;
			jogador.id_sala = 6;
			jogador.c6.run();
		}
		if (tileCollision(3, jogador, cena) == true) {
			jogador.x = 380;
			jogador.y = 300;
			jogador.id_sala = 12;
			jogador.c12.run();
		}
	}
}
