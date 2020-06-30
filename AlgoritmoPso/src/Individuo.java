import java.util.Random;

public class Individuo {
	double velocidade;
	double posicao;
	double melhorPosicao;
	double fitness;
	Random gerador = new Random();
	
	public Individuo() {
		this.velocidade = 1.5;
		this.posicao = gerador.nextInt(100);
		this.melhorPosicao = posicao;
	}
	
	public void calcularFitness() {
		fitness = posicao * 2;
	}
	
	public void calcularMelhorPosicao() {
		if(posicao < melhorPosicao) {
			melhorPosicao = posicao;
		}
	}

	@Override
	public String toString() {
		return "Individuo [velocidade=" + velocidade + ", posicao=" + posicao + ", melhorPosicao=" + melhorPosicao
				+ ", fitness=" + fitness + "]";
	}
	
}
