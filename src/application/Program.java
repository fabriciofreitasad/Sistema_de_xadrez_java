package application;

import xadrez.XadrezPartida;

public class Program {

	public static void main(String[] args) {
		
		XadrezPartida xadrezPartida = new XadrezPartida();
		
		UI.printMesa(xadrezPartida.getPecas());


	}

}
