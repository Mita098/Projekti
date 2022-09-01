package mini_projekat;

import java.util.ArrayList;

public class XandOGame {
	private ArrayList<String> table = new ArrayList<String>();
	private Player nextPlayer;
	private Player playerX;
	private Player playerO;

	public XandOGame() {
		for (int i = 0; i < 9; i++) {
			String x = " ";
			this.table.add(x);
		}

	}

	public XandOGame(Player playerX, Player playerO) {
		this.playerX = playerX;
		this.playerO = playerO;
		for (int i = 0; i < 9; i++) {
			String x = " ";
			table.add(x);
		}
	}

	public Player getPlayerX() {
		return playerX;
	}

	public void setPlayerX(Player playerX) {
		this.playerX = playerX;
	}

	public Player getPlayerO() {
		return playerO;
	}

	public void setPlayerO(Player playerO) {
		this.playerO = playerO;
	}

	public void print() {
		int brojac = 0;
		for (int i = 0; i < 9; i++) {
			System.out.print(this.table.get(i) + " | ");
			brojac++;
			if (brojac % 3 == 0) {
				System.out.println();
			}
		}
	}

	public void startGame() {
		for (int i = 0; i < 9; i++) {
			String x = " ";
			table.add(x);
		}
		this.nextPlayer = this.playerX;
	}

	public boolean isGameOver() {
		for (int i = 0; i < 9; i++) {
			if (this.table.get(i).equals(" ")) {
				return false;
			}
		}
		return true;
	}

	public boolean isFieldFree(ArrayList<String> table, int pozicija) {
		table = this.table;
		if (this.table.get(pozicija).equals(" ")) {
			return true;
		} else {
			return false;
		}
	}

	public void playNext() {
		if (this.nextPlayer == this.playerO) {
			this.nextPlayer = this.playerX;
		} else {
			this.nextPlayer = this.playerO;
		}
	}

	public void makeAMove(int pozicija) {
		if (this.nextPlayer == this.playerO) {
			this.table.set(pozicija, "o");
		} else {
			this.table.set(pozicija, "x");
		}
	}

	public Player isWinnerX() {
		String parametar = "x";
		if (this.daLiJeWiner(parametar)) {
			return this.playerX;
		} else {
			return null;
		}
	}

	public Player isWinnerO() {
		String parametar = "o";
		if (this.daLiJeWiner(parametar)) {
			return this.playerO;
		} else {
			return null;
		}
	}

	public boolean isValidMove(int pozicija) {
		if (pozicija >= 0 && pozicija <= 8) {
			return true;
		}
		return false;
	}

	public int gameScore() {
		if (this.isWinnerX() != null) {
			return 1;
		} else if (this.isWinnerO() != null) {
			return 2;
		} else {
			return 0;
		}
	}

	public void gameScoreStampa() {
		if (this.gameScore() == 1) {
			System.out.println("Pobednik je igrac X : " + this.playerX.getImePrezime());
		} else if (this.gameScore() == 2) {
			System.out.println("Pobednik je igrac O : " + this.playerO.getImePrezime());
		} else {
			System.out.println("Nemamo pobednika, nereseno je.");
		}
	}

	public int petljaUslov() {
		if (this.isGameOver()) {
			return 1;
		} else if (this.isWinnerO() != null) {
			return 1;
		} else if (this.isWinnerX() != null) {
			return 1;
		} else
			return 0;
	}

	public boolean daLiJeValidno(int potez) {
		if (this.isFieldFree(this.table, potez) && this.isValidMove(potez)) {
			return true;
		}
		return false;
	}

	private boolean daLiJeWiner(String parametar) {
		if (this.table.get(0).equals(parametar) && this.table.get(1).equals(parametar)
				&& this.table.get(2).equals(parametar)
				|| this.table.get(3).equals(parametar) && this.table.get(4).equals(parametar)
						&& this.table.get(5).equals(parametar)
				|| this.table.get(6).equals(parametar) && this.table.get(7).equals(parametar)
						&& this.table.get(8).equals(parametar)
				|| this.table.get(0).equals(parametar) && this.table.get(3).equals(parametar)
						&& this.table.get(6).equals(parametar)
				|| this.table.get(1).equals(parametar) && this.table.get(4).equals(parametar)
						&& this.table.get(7).equals(parametar)
				|| this.table.get(2).equals(parametar) && this.table.get(5).equals(parametar)
						&& this.table.get(8).equals(parametar)
				|| this.table.get(0).equals(parametar) && this.table.get(4).equals(parametar)
						&& this.table.get(8).equals(parametar)
				|| this.table.get(2).equals(parametar) && this.table.get(4).equals(parametar)
						&& this.table.get(6).equals(parametar)) {
			return true;
		} else {
			return false;
		}
	}
}