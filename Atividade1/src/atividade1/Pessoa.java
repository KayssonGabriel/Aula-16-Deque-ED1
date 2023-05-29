package atividade1;

public class Pessoa {
	private int id;
	private String sexo;
	private int idade;
	private boolean gestante;
	private boolean lactante;
	private boolean necessidadeEspecial;

	public Pessoa(int id, String sexo, int idade, boolean gestante, boolean lactante, boolean necessidadeEspecial) {
		super();
		this.id = id;
		this.sexo = sexo;
		this.idade = idade;
		this.gestante = gestante;
		this.lactante = lactante;
		this.necessidadeEspecial = necessidadeEspecial;
	}

	public int getId() {
		return id;
	}

	public String getSexo() {
		return sexo;
	}

	public int getIdade() {
		return idade;
	}

	public boolean isGestante() {
		return gestante;
	}

	public boolean isLactante() {
		return lactante;
	}

	public boolean isNecessidadeEspecial() {
		return necessidadeEspecial;
	}

	@Override
	public String toString() {
		return "[ID: " + id + ", Sexo: " + sexo + ", Idade: " + idade + ", Gestante: " + (gestante ? "Sim" : "Não")
				+ ", Lactante: " + (lactante ? "Sim" : "Não") + ", Necessidade Especial: "
				+ (necessidadeEspecial ? "Sim" : "Não") + "]" + " -- ";

	}

}
