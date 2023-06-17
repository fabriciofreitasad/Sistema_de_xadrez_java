package xadrez;


import tabuleiro.Mesa;
import tabuleiro.Posicao;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class XadrezPartida {

	private Mesa mesa;

	public XadrezPartida() {
		mesa = new Mesa(8, 8);
		initialSetup();
	}
	
	public XadrezPeca[][]getPecas() {
		XadrezPeca[][] mat = new XadrezPeca[mesa.getLinhas()][mesa.getColunas()];
		for (int i=0; i<mesa.getLinhas(); i++) {
			for (int j=0; j<mesa.getColunas(); j++) {
				mat[i][j] = (XadrezPeca) mesa.peca(i, j);
			}
		}
		return mat;
	}

	private void initialSetup() {
		mesa.pecaNaPosicao(new Torre(mesa, Color.WHITE), new Posicao(2, 1));
		mesa.pecaNaPosicao(new Rei(mesa, Color.BLACK), new Posicao(0, 4));
		mesa.pecaNaPosicao(new Rei(mesa, Color.WHITE), new Posicao(7, 4));

	}

}
