package mini_projekat;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Player iks = new Player();
		Player oks = new Player();
		iks.dodajIks();
		oks.dodajOks();
		XandOGame d = new XandOGame(iks, oks);
		d.startGame();
		d.print();
		while (d.petljaUslov() == 0) {
			System.out.print("Unesite poziciju: ");
			int potez = s.nextInt();
			if (d.daLiJeValidno(potez)) {
				d.makeAMove(potez);
				d.playNext();
				d.print();
			} else {
				System.out.println("You enter invalid position.");
			}
		}
		d.gameScoreStampa();
	}

}
