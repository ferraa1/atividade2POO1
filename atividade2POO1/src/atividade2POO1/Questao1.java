package atividade2POO1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Questao1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random randy = new Random();

		boolean continuar = true;
		char option;
		int qtd;
		
		do {
			do {
				
				System.out.println("Informe a quantidade de números: ");
				qtd = sc.nextInt();
				
				if (qtd < 1)
					System.out.println("Entrada inválida! Informe um valor maior que zero.");
				
			} while (qtd < 1);
			
			int maior = Integer.MIN_VALUE;
			int menor = Integer.MAX_VALUE;
			
			int numeros[] = new int[qtd];
			int pares[] = new int[qtd];
			int impares[] = new int[qtd];
			int primos[] = new int[qtd];
			int moda[] = new int[qtd];

			int temp;
			int soma = 0;
			double mediana;
			double variancia = 0;
			
			for (int i = 0; i < qtd; i++) {
				
				temp = randy.nextInt(5001);
				numeros[i] = temp;
				
				soma += temp;
				
				if (temp > maior)
					maior = temp;
				if (temp < menor)
					menor = temp;
				
				if (temp % 2 == 0) {
					pares[i] = temp;
					impares[i] = -1;
				} else {
					impares[i] = temp;
					pares[i] = -1;
				}
				
				for (int j = 2; j < temp / 2; j++) {
					if (temp % j == 0) {
						primos[i] = -1;
					}
				}
				if (primos[i] != -1)
					primos[i] = temp;
				
			}
			
			Arrays.sort(numeros);
			
			int cont = 1;
			int max = 1;
			for (int i = 0; i < qtd; i++) {
				for (int j = i; j < qtd; j++) {
					if (i != j && numeros[i] == numeros[j])
						cont++;
					else if (i != j)
						break;
				}
				moda[i] = cont;
				if (cont > max)
					max = cont;
				cont = 1;
			}
			
			if (qtd % 2 == 0) {
				mediana = (numeros[(qtd / 2)] + numeros[(qtd / 2 - 1)]) / 2;
			} else {
				mediana = numeros[(qtd / 2)];
			}
			
			int media = soma / qtd;
			for (int i = 0; i < qtd; i++) {
				variancia += (numeros[i] - media) * (numeros[i] - media);
			}
			variancia = variancia / qtd;
			double desvio = Math.sqrt(variancia);
			
			System.out.println("Maior número: " + maior);
			System.out.println("Menor número: " + menor);
			System.out.println("Lista dos números pares: ");
			for (int i = 0; i < qtd; i++) {
				if (pares[i] != -1)
					System.out.print(pares[i] + " ");
			}
			System.out.println();
			System.out.println("Lista dos números ímpares: ");
			for (int i = 0; i < qtd; i++) {
				if (impares[i] != -1)
					System.out.print(impares[i] + " ");
			}
			System.out.println();
			System.out.println("Lista dos números primos: ");
			for (int i = 0; i < qtd; i++) {
				if (primos[i] != -1)
					System.out.print(primos[i] + " ");
			}
			System.out.println();
			System.out.println("Soma: " + soma);
			System.out.println("Média: " + media);
			System.out.println("Moda: ");
			for (int i = 0; i < qtd; i++) {
				if (moda[i] == max)
					System.out.print(numeros[i] + " ");
			}
			System.out.println();
			System.out.println("Mediana: " + mediana);
			System.out.println("Variância: " + variancia);
			System.out.println("Desvio padrão: " + desvio);
			System.out.println("Vetor formado: ");
			for (int i = 0; i < qtd; i++) {
				System.out.print(numeros[i] + " ");
			}
			System.out.println();
			
			do {
				
				System.out.println("Deseja iniciar o processo novamente? (s = sim, n = não): ");
				option = sc.next().charAt(0);
				
				if (option != 's' && option != 'S' && option != 'n' && option != 'N')
					System.out.println("Entrada inválida! Informe s ou n.");
				else
					if (option == 'n' || option == 'N')
						continuar = false;
				
			} while (option != 's' && option != 'S' && option != 'n' && option != 'N');
		} while (continuar);
		
		sc.close();
		
	}

}
