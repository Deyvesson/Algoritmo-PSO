import java.util.ArrayList;

public class Populacao {
	ArrayList<Individuo> individuos = new ArrayList();
	Individuo individuo= new Individuo();

	double gBest = -11;
	
	public Populacao(){
		for(int i = 0; i <21; i++) {
			Individuo individuo = new Individuo();
			individuos.add(individuo);
		}
	}
	
	public void calcularGbest() {
		Individuo melhor = individuos.get(0);
		for(int i = 1; i < individuos.size(); i++) {
			if(individuos.get(i).fitness > melhor.fitness) {
				melhor = individuos.get(i);
			}
		}
		
		if(gBest == -11) {gBest = melhor.posicao;}
		else if(melhor.fitness >  melhor.calcularFitness(gBest)) {
			gBest = melhor.posicao;
		}
	}
}
