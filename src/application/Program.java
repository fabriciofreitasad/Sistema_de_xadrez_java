package application;

import java.util.Scanner;

import xadrez.XadrezPartida;
import xadrez.XadrezPeca;
import xadrez.XadrezPosicao;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		XadrezPartida xadrezPartida = new XadrezPartida();
		
		while(true) {
			UI.printMesa(xadrezPartida.getPecas());
			System.out.println();
			System.out.println("Origem");
			XadrezPosicao origem = UI.lerXadrezPosicao(sc);
			
			System.out.println();
			System.out.println("Destino");
			XadrezPosicao destino = UI.lerXadrezPosicao(sc);
			
			XadrezPeca capturePeca = xadrezPartida.realizeOmovimentoDoXadrez(origem, destino);
			
		}
		
	}
}
