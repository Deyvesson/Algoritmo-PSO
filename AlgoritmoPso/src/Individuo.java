import java.util.Random;

public class Individuo {
	double velocidade;
	double posicao;
	double melhorPosicao;
	double fitness;
	Random gerador = new Random();
	
	public Individuo() {
		this.velocidade = 1.5;
		this.posicao = gerador.nextInt(20)-10;
		this.melhorPosicao = posicao;
	}
	
	public double calcularFitness(double posicao) {
		fitness = (-1* Math.pow(posicao, 2)) - (8*posicao);
		return fitness;
	}
	
	public void calcularMelhorPosicao() {
		if(calcularFitness(melhorPosicao) < calcularFitness(posicao)) {
			melhorPosicao = posicao;
		}
	}

	@Override
	public String toString() {
		return "Individuo [velocidade=" + velocidade + ", posicao=" + posicao + ", melhorPosicao=" + melhorPosicao
				+ ", fitness=" + fitness + "]";
	}
	
}
