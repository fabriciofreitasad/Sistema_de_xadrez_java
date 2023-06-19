package xadrez;


import tabuleiro.Mesa;
import tabuleiro.Peca;
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
	
	public XadrezPeca realizeOmovimentoDoXadrez(XadrezPosicao origemPosicao, XadrezPosicao destinoPosicao) {
		Posicao origem = origemPosicao.toPosicao();
		Posicao destino = destinoPosicao.toPosicao();
		validacaoSourcePosicao(origem);
		Peca capturaPeca = makeMove(origem, destino);
		return (XadrezPeca)capturaPeca;
	}
	
	private Peca makeMove(Posicao origem, Posicao destino) {
		Peca p = mesa.removePeca(origem);
		Peca capturePeca = mesa.removePeca(destino);
		mesa.pecaNaPosicao(p, destino);
		return capturePeca;
	}
	
	private void validacaoSourcePosicao(Posicao posicao) {
		if(!mesa.temPeca(posicao)) {
			throw new XadrezException("não existe peça na posição de origem");
		}
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
