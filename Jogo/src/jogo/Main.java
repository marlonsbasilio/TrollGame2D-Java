package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window janela = new Window(800, 600);
		GameImage plano = new GameImage(URL.sprite("tela_inicial.png"));
		Keyboard teclado = janela.getKeyboard();
		
		while(true) {
			plano.draw();
			janela.update();
			
			if (teclado.keyDown(Keyboard.ENTER_KEY)) {
				Jogador player = new Jogador(300, 300, janela);
			}
		}
	}

}
