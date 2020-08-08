import java.util.Random;
import java.util.Scanner;

public class Algoritmo {
	double pesoInercial = 0.9, c1 = 0.8, c2 = 1.2;
	Populacao p = new Populacao();
	
	public void atualizarVelocidade(Individuo i) {
		double novaVelocidade = pesoInercial * i.velocidade + c1*Math.random()*(i.melhorPosicao - i.posicao) + c2 * Math.random()*(p.gBest - i.posicao);		
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
			for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
				System.out.println("Posi��o: " + algoritmo.p.individuos.get(j).posicao + " Fitness: " + algoritmo.p.individuos.get(j).calcularFitness(algoritmo.p.individuos.get(j).posicao));
				}
			for(int i =0 ;i < 100; i++) {
				//System.out.println("Popula��o:" + i);
				//Calcular fitness e Calcular Melhor posi��o
				for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
					algoritmo.p.individuos.get(j).calcularFitness(algoritmo.p.individuos.get(j).posicao);
					algoritmo.p.individuos.get(j).calcularMelhorPosicao();
				}
				
				//Calcular melhor aptid�o
				algoritmo.p.calcularGbest();
								
				//System.out.println("melhor posic�o global: "+algoritmo.p.gBest);
				//Atualizar velocidade e atualizar posi��o
				for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
					algoritmo.atualizarVelocidade(algoritmo.p.individuos.get(j));
					algoritmo.AtualizarPosicao(algoritmo.p.individuos.get(j));
				}
				

				//System.out.println("");
			}
			for(int j = 0; j < algoritmo.p.individuos.size(); j++) {
				System.out.println("Posi��o: " + algoritmo.p.individuos.get(j).posicao + " Fitness: " + algoritmo.p.individuos.get(j).calcularFitness(algoritmo.p.individuos.get(j).posicao) + " Melhor posi��o: " + algoritmo.p.individuos.get(j).melhorPosicao);
				}
			Scanner entrada = new Scanner(System.in);
			System.out.println("Rodar mais 100?");
			rodar =  + entrada.nextInt();
		}
	}

}
