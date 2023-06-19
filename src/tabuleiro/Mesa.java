package tabuleiro;

public class Mesa {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Mesa(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new MesaException("Error creating board: there must be at least 1 linha and 1 coluna");
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
	
	public Peca peca(int linha, int coluna) {
		if (!posicaoExists(linha, coluna)) {
			throw new MesaException("Essa posição não esá no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!posicaoExists(posicao)) {
			throw new MesaException("Essa posição não esá no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void pecaNaPosicao(Peca peca, Posicao posicao) {
		if (temPeca(posicao)) {
			throw new MesaException("There is already a peca on posicao " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!posicaoExists(posicao)) {
			throw new MesaException("Essa posição não esá no tabuleiro");
		}
		if(peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	
	private boolean posicaoExists(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExists(Posicao posicao) {
		return posicaoExists(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temPeca(Posicao posicao) {
		if (!posicaoExists(posicao)) {
			throw new MesaException("Posicao not on the board");
		}
		return peca(posicao) != null;
	}

}
