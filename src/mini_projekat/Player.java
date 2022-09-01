package mini_projekat;

import java.util.Scanner;

public class Player {
	Scanner s = new Scanner(System.in);
	private String imePrezime;

	public Player() {
		super();
	}

	public Player(String imePrezime) {
		super();
		this.imePrezime = imePrezime;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public void print() {
		System.out.println(this.imePrezime);
	}

	public void dodajIks() {
		System.out.print("Unesite ime i prezime igraca Iks ");
		this.imePrezime = s.next();
		this.imePrezime = this.imePrezime + s.nextLine();
	}

	public void dodajOks() {
		System.out.print("Unesite ime i prezime igraca Oks ");
		this.imePrezime = s.next();
		this.imePrezime = this.imePrezime + s.nextLine();
	}

}
