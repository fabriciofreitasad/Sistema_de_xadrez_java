package tabuleiro;



public class Mesa {
	

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Mesa(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new ExceptionMesa("Error creating board: there must be at least 1 linhas and 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linhas, int colunas) {
		if (!posicaoExists(linhas, colunas)) {
			throw new ExceptionMesa("Posicao not on the board");
		}
		return pecas[linhas][colunas];
	}
	
	public Peca peca(Posicao posicao) {
		if (!posicaoExists(posicao)) {
			throw new ExceptionMesa("Posicao not on the board");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void pecaNaPosicao(Peca piece, Posicao posicao) {
		if (temPeca(posicao)) {
			throw new ExceptionMesa("There is already a piece on posicao " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = piece;
		piece.posicao = posicao;
	}
	
	private boolean posicaoExists(int linhas, int colunas) {
		return linhas >= 0 && linhas < linhas && colunas >= 0 && colunas < colunas;
	}
	
	public boolean posicaoExists(Posicao posicao) {
		return posicaoExists(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temPeca(Posicao posicao) {
		if (!posicaoExists(posicao)) {
			throw new ExceptionMesa("Posicao not on the board");
		}
		return peca(posicao) != null;
	}

}
