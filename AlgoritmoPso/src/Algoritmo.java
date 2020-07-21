import java.util.Scanner;

public class Algoritmo {

	Populacao p = new Populacao();
	
	public void atualizarVelocidade(Individuo i) {
		double novaVelocidade = i.velocidade + 0.8*(i.melhorPosicao - i.posicao) + 0.8*(p.melhorAptidao - i.posicao);		
		if(novaVelocidade > 10) {i.velocidade = 10;}
		else if(novaVelocidade < -10) {i.velocidade = -10;}
		else {i.velocidade = novaVelocidade;}
		
	}
	
	public void AtualizarPosicao(Individuo i) {
		i.posicao = i.posicao + i.velocidade;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Algoritmo algoritmo = new Algoritmo();
		int rodar = 1;
		while(rodar == 1) {
			for(int i =0 ;i < 100; i++) {
				System.out.println("População:" + i);
				algoritmo.p.individuo1.calcularFitness();
				algoritmo.p.individuo2.calcularFitness();
				algoritmo.p.individuo3.calcularFitness();
				algoritmo.p.individuo1.calcularMelhorPosicao();
				algoritmo.p.individuo2.calcularMelhorPosicao();
				algoritmo.p.individuo3.calcularMelhorPosicao();
				algoritmo.p.calcularMelhorAp();
				System.out.println(algoritmo.p.individuo1.toString());
				System.out.println(algoritmo.p.individuo2.toString());
				System.out.println(algoritmo.p.individuo3.toString());
				System.out.println("melhor Fitness: "+algoritmo.p.melhorAptidao);
				algoritmo.atualizarVelocidade(algoritmo.p.individuo1);
				algoritmo.atualizarVelocidade(algoritmo.p.individuo2);
				algoritmo.atualizarVelocidade(algoritmo.p.individuo3);
				algoritmo.AtualizarPosicao(algoritmo.p.individuo1);
				algoritmo.AtualizarPosicao(algoritmo.p.individuo2);
				algoritmo.AtualizarPosicao(algoritmo.p.individuo3);
				System.out.println("");
			}
			Scanner entrada = new Scanner(System.in);
			System.out.println("Continuar?");
			rodar =  + entrada.nextInt();
		}
	}

}
