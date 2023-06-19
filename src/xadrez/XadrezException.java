package xadrez;

import tabuleiro.MesaException;

public class XadrezException extends MesaException {

	private static final long serialVersionUID = 1L;
	
	public  XadrezException (String msg) {
		super(msg);
	}

}
