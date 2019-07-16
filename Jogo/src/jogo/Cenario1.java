package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;


public class Cenario1 extends Cenario{
	
	private Window janela;
	private Scene cena;
	private Jogador jogador = null;
	private Keyboard teclado;
	
	public Cenario1 (Window window, Jogador player) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1_11_14.scn"));
		jogador = player;
		teclado = janela.getKeyboard();
		
	}
	public void run() {
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
//			
			janela.update();
			mudarCenario();
		}
	}
	private void mudarCenario() {
		if (tileCollision(3, jogador, cena) == true) {
			jogador.x = 300;
			jogador.y = 240;
			jogador.id_sala = 2;
			jogador.c2.run();
		}
		if (tileCollision(2, jogador, cena) == true) {
			jogador.x = 380;
			jogador.y = 300;
			jogador.id_sala = 6;
			jogador.c6.run();
		}
	}
}
