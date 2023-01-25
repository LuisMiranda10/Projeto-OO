package models;

import java.util.*;

public class Dados {
	private ArrayList<Animal> animais = new ArrayList<Animal>();
	private int qtdAnimais = 0;
	private ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
	private int qtdVacinas = 0;
	
	public void EncherDados() {
		for(int i = 0; i < 5; i++) {
			Cachorro cachorro = new Cachorro("Cachorro" + i, "canina" + i, "raca" + i, "genero" + i, i, "altura" + i, 
			"situacao Focinho" + i);
			Coelho coelho = new Coelho("Coelho" + i, "roedor" + i, "raca" + i, "genero" + i, i, "altura" + i, 
					"situacao Dentes" + i);
			Gato gato = new Gato("Gato" + i, "felina" + i, "raca" + i, "genero" + i, i, "altura" + i, 
					"Pelagem" + i);
			Vacina vacina = new Vacina("Vacina" + i, "12/10/2022" + i, "14/10/2023" + i, "local" + i, "n lote" + i, i);
	
			animais.add(cachorro);
			animais.add(coelho);
			animais.add(gato);
			vacinas.add(vacina);
		}
	}
	
	public ArrayList<Animal> getAnimais() {
		return animais;
	}
	
	public int getQtdAnimais() {
        qtdAnimais = this.animais.size();
        return qtdAnimais;
    }
	
	public void setQtdAnimais(int qtdAnimais) {
        this.qtdAnimais = qtdAnimais;
    }
	
	public ArrayList<Vacina> getVacinas() {
		return vacinas;
	} 	
	
	public int getQtdVacinas() {
        qtdVacinas = this.animais.size();
        return qtdVacinas;
    }
	
	public void setQtdVacinas(int qtdVacinas) {
        this.qtdVacinas = qtdVacinas;
    }
	
	public void adicionarAnimal(Cachorro cachorro, Coelho coelho, Gato gato) {
		this.animais.add(cachorro);
		this.animais.add(coelho);
		this.animais.add(gato);
	}
	
	public void adicionarVacina(Vacina vacina) {
		this.vacinas.add(vacina);
	}
}