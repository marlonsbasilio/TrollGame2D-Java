package jogo;

import java.util.LinkedList;

import jplay.Scene;
//import jplay.Sound;

public class ControleAtirar {
	
	LinkedList <Atirar> axe = new LinkedList<>();
	
	public void Addmachado(double x, double y, int caminho, Scene cena) {
		Atirar machado = new Atirar(x, y, caminho);
		axe.addFirst(machado);
		cena.addOverlay(machado);
		somDisparo();
		
	}
	
	public void run(Criatura troll) {
		for ( int i = 0; i < axe.size(); i++) {
			Atirar machado = axe.removeFirst();
			machado.mover();
			axe.addLast(machado);
			
			if (machado.collided(troll)) {
				machado.x = 10_000;
				machado.y = 10_000;
				troll.vida -= 250;
			}
			else if (machado.x > 600 || machado.x < 200 || machado.y > 500 || machado.y < 50) {
				machado.x = 10_000;
				machado.y = 10_000;
			}
		}
	}
	
	public void MachadoTroll(Criatura troll) {
		for ( int i = 0; i < axe.size(); i++) {
			Atirar machado = axe.removeFirst();
			machado.mover();
			axe.addLast(machado);
			
			if (machado.collided(troll)) {
				machado.x = 10_000;
				machado.y = 10_000;
				troll.vida -= 250;
			}
		}
	}
	void somDisparo() {
	}
}
