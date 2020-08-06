import java.util.ArrayList;

public class Populacao {
	ArrayList<Individuo> individuos = new ArrayList();
	Individuo individuo= new Individuo();

	double melhorAptidao = -11;
	
	public Populacao(){
		for(int i = 0; i <6; i++) {
			Individuo individuo = new Individuo();
			individuos.add(individuo);
		}
	}
	
	public void calcularMelhorAp() {
		double melhor = individuos.get(0).posicao;
		for(int i = 1; i < individuos.size(); i++) {
			if(individuos.get(i).posicao > melhor) {
				melhor = individuos.get(i).posicao;
			}
		}
		
		if(melhorAptidao == -11) {melhorAptidao = melhor;}
		else if(melhor > melhorAptidao) {
			melhorAptidao = melhor;
		}
	}
}
