package xadrez;


import tabuleiro.Mesa;
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
	
	private void pecaNavaPosicao(char coluna, int linha , XadrezPeca peca) {
		mesa.pecaNaPosicao(peca,new XadrezPosicao(coluna, linha).toPosicao() );
	}

	private void initialSetup() {
		
		pecaNavaPosicao('c', 2, new Torre(mesa, Color.WHITE));
        pecaNavaPosicao('d', 2, new Torre(mesa, Color.WHITE));
        pecaNavaPosicao('e', 2, new Torre(mesa, Color.WHITE));
        pecaNavaPosicao('e', 1, new Torre(mesa, Color.WHITE));
        pecaNavaPosicao('d', 1, new Rei(mesa, Color.WHITE));

        pecaNavaPosicao('c', 7, new Torre(mesa, Color.BLACK));
        pecaNavaPosicao('c', 8, new Torre(mesa, Color.BLACK));
        pecaNavaPosicao('d', 7, new Torre(mesa, Color.BLACK));
        pecaNavaPosicao('e', 7, new Torre(mesa, Color.BLACK));
        pecaNavaPosicao('e', 8, new Torre(mesa, Color.BLACK));
        pecaNavaPosicao('d', 8, new Rei(mesa, Color.BLACK));

	}

}
