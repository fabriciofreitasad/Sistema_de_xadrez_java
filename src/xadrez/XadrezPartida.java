package xadrez;

import tabuleiro.Mesa;

public class XadrezPartida {
	
	private Mesa mesa;
	
	public XadrezPartida() {
		mesa = new Mesa(8,8);
	}
	
	public XadrezPeca[][] getPecas(){
		XadrezPeca[][] mat = new XadrezPeca[mesa.getLinha()][mesa.getColuna()];
		for(int i=0; i<mesa.getLinha(); i++) {
			for(int j=0; j<mesa.getColuna(); j++) {
				mat[i][j] = (XadrezPeca) mesa.peca(i, j);
			}
		}
		return mat;
	}

}
