package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;


public class Cenario5 extends Cenario{
	
	private Window janela;
	private Scene cena;
	private Jogador jogador = null;
	private Keyboard teclado;
	private Troll troll[];
	private boolean access = false;
	private Ouro ouro;
	
	public Cenario5 (Window window, Jogador player) {
		
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario3_5_7.scn"));
		jogador = player;
		teclado = janela.getKeyboard();
		troll = new Troll[5];
		ouro = new Ouro(480, 300);
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
			jogador.potion_use(teclado);
			
			ouro.x += cena.getXOffset();
			ouro.y += cena.getYOffset();
			ouro.draw();
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
			jogador.id_sala = 4;
			jogador.c4.run();
		}
		if (tileCollision(3, jogador, cena) == true) {
			jogador.x = 380;
			jogador.y = 160;
			jogador.id_sala = 10;
			jogador.c10.run();
		}
	}
}
