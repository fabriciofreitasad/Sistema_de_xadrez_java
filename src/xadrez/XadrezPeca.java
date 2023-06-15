package xadrez;

import tabuleiro.Mesa;
import tabuleiro.Peca;

public class XadrezPeca extends Peca {
	private Color color;

	public XadrezPeca(Mesa mesa, Color color) {
		super(mesa);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}
