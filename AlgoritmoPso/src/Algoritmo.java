import java.util.Scanner;

public class Algoritmo {

	Populacao p = new Populacao();
	
	public void atualizarVelocidade(Individuo i) {
		double novaVelocidade = i.velocidade + 0.1*(i.melhorPosicao - i.posicao) + 0.1*(p.melhorAptidao - i.posicao);		
		if(novaVelocidade > 10) {i.velocidade = 10;}
		else if(novaVelocidade < -10) {i.velocidade = -10;}
		else {i.velocidade = novaVelocidade;}
		
	}
	
	public void AtualizarPosicao(Individuo i) {
		i.posicao = i.posicao + i.velocidade;
		if(i.posicao > 10) {i.posicao = 10;}
		else if(i.posicao < -10) {i.posicao = -10;}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Algoritmo algoritmo = new Algoritmo();
		int rodar = 1;
		while(rodar == 1) {
			for(int i =0 ;i < 100; i++) {
				System.out.println("População:" + i);
				//Calcular fitness
				for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
					algoritmo.p.individuos.get(j).calcularFitness(algoritmo.p.individuos.get(j).posicao);
				}
				//Calcular Melhor posição
				for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
					algoritmo.p.individuos.get(j).calcularMelhorPosicao();
				}
				algoritmo.p.calcularMelhorAp();
				
				for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
					System.out.println(algoritmo.p.individuos.get(j).toString());
				}
				System.out.println("melhor posicão global: "+algoritmo.p.melhorAptidao);
				
				for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
					algoritmo.atualizarVelocidade(algoritmo.p.individuos.get(j));
				}

				for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
					algoritmo.AtualizarPosicao(algoritmo.p.individuos.get(j));
				}

				System.out.println("");
			}
			Scanner entrada = new Scanner(System.in);
			System.out.println("Rodar mais 100?");
			rodar =  + entrada.nextInt();
		}
	}

}
