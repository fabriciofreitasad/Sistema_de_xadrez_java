package xadrez.pecas;

import tabuleiro.Mesa;
import xadrez.Color;
import xadrez.XadrezPeca;

public class Torre extends XadrezPeca {

	public Torre(Mesa mesa, Color color) {
		super(mesa, color);
		
	}
	
	@Override
	public String toString() {
		return "T";
	}

}
