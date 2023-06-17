package xadrez.pecas;

import tabuleiro.Mesa;
import xadrez.Color;
import xadrez.XadrezPeca;

public class Rei extends XadrezPeca {

	public Rei(Mesa mesa, Color color) {
		super(mesa, color);
	}

	@Override
	public String toString() {
		return "R";
	}

}
