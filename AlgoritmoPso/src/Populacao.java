
public class Populacao {
	Individuo individuo1 = new Individuo();
	Individuo individuo2 = new Individuo();
	Individuo individuo3 = new Individuo();
	double melhorAptidao = -1;
	
	public void calcularMelhorAp() {
		double melhor;
		if(individuo1.fitness <= individuo2.fitness && individuo1.fitness <= individuo3.fitness) {
			melhor = individuo1.fitness;}
		else if(individuo2.fitness <= individuo1.fitness && individuo2.fitness <= individuo3.fitness) {
			melhor = individuo2.fitness;}
		else {melhor = individuo3.fitness;}
		
		if(melhorAptidao == -1) {melhorAptidao = melhor;}
		else if(melhor < melhorAptidao) {
			melhorAptidao = melhor;
		}
	}
}
