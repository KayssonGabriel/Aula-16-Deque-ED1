package atividade1;

import java.util.Random;

public class Program {
	public static void main(String[] args) {
		Deque<Pessoa> dequeNormal = new Deque<>();
		Deque<Pessoa> dequeAcima60 = new Deque<>();
		Deque<Pessoa> dequeNecessidadesEspeciais = new Deque<>();
		Deque<Pessoa> dequeGestanteOuLactante = new Deque<>();
		Deque<Pessoa> dequeAtendidos = new Deque<>();
		Deque<Pessoa> dequeNaoAtendidos = new Deque<>();

		Random random = new Random();

		for (int j = 1; j <= 10; j++) {

			for (int i = 1; i <= 10; i++) {
				int id = i;
				boolean gestante = false;
				boolean lactante = false;
				boolean necessidadeEspecial = random.nextBoolean();
				int idade = random.nextInt(90) + 5;
				String sexo = random.nextBoolean() ? "Masculino" : "Feminino";

				if (sexo.equals("Feminino")) {
					gestante = random.nextBoolean();
					lactante = random.nextBoolean();
				}

				Pessoa pessoa = new Pessoa(id, sexo, idade, gestante, lactante, necessidadeEspecial);

				if (pessoa.isGestante() == true || pessoa.isLactante() == true) {
					dequeGestanteOuLactante.adicionaNoFinal(pessoa);
				} else if (pessoa.isNecessidadeEspecial() == true) {
					dequeNecessidadesEspeciais.adicionaNoFinal(pessoa);
				} else if (pessoa.getIdade() > 60) {
					dequeAcima60.adicionaNoFinal(pessoa);
				} else {
					dequeNormal.adicionaNoFinal(pessoa);
				}
			}
			for (int i = 1; i <= j; i++) {
				if (!(dequeGestanteOuLactante.isEmpty())) {
					dequeAtendidos.adicionaNoFinal(dequeGestanteOuLactante.getInicio());
					dequeGestanteOuLactante.removeDoInicio();
				} else if (!(dequeNecessidadesEspeciais.isEmpty())) {
					dequeAtendidos.adicionaNoFinal(dequeNecessidadesEspeciais.getInicio());
					dequeNecessidadesEspeciais.removeDoInicio();
				} else if (!(dequeAcima60.isEmpty())) {
					dequeAtendidos.adicionaNoFinal(dequeAcima60.getInicio());
					dequeAcima60.removeDoInicio();
				} else {
					dequeAtendidos.adicionaNoFinal(dequeNormal.getInicio());
					dequeNormal.removeDoInicio();
				}
			}
		}
		System.out.println("Quantidade atendidos " + dequeAtendidos.size());
		System.out.print("Pacientes atendidos: ");
		dequeAtendidos.imprimir();

		int tamanhoNaoAtendidos = dequeGestanteOuLactante.size() + dequeNecessidadesEspeciais.size()
				+ dequeAcima60.size() + dequeNormal.size();

		for (int i = 1; i <= tamanhoNaoAtendidos; i++) {
			if (!(dequeGestanteOuLactante.isEmpty())) {
				dequeNaoAtendidos.adicionaNoFinal(dequeGestanteOuLactante.getInicio());
				dequeGestanteOuLactante.removeDoInicio();
			} else if (!(dequeNecessidadesEspeciais.isEmpty())) {
				dequeNaoAtendidos.adicionaNoFinal(dequeNecessidadesEspeciais.getInicio());
				dequeNecessidadesEspeciais.removeDoInicio();
			} else if (!(dequeAcima60.isEmpty())) {
				dequeNaoAtendidos.adicionaNoFinal(dequeAcima60.getInicio());
				dequeAcima60.removeDoInicio();
			} else {
				dequeNaoAtendidos.adicionaNoFinal(dequeNormal.getInicio());
				dequeNormal.removeDoInicio();
			}
		}

		System.out.println();
		System.out.println("Quantidade não atendidos " + dequeNaoAtendidos.size());
		System.out.print("Pacientes não atendidos: ");
		dequeNaoAtendidos.imprimir();

	}
}
