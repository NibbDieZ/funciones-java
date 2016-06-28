/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nibb10
 */
import java.util.Scanner;
import java.util.Random;

public class EjercicioFunciones3 {
	public static void main(String[] args) {
		double valorM3 = 0;
		double cargofijo = 0;
		double consumoAnual = 0;
		double consumoAguaAnual = 0;
		int pisos[] = new int[8];
		int maxMes = 0;
		double maxMesCon = 0;
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		double consumoM3[][] = new double[32][12];
		double consumoM3Mes[] = new double[12];
		for (int a = 0; a < 32; a++) {
			for (int b = 0; b < 12; b++) {
				consumoM3[a][b] = random.nextInt(21);
				if (consumoM3[a][b] <= 5) {
					valorM3 = 100;
					consumoAnual += (valorM3 * consumoM3[a][b]);
					consumoAguaAnual += consumoM3[a][b];
				} else if (consumoM3[a][b] > 5 && consumoM3[a][b] < 12) {
					valorM3 = 100;
					cargofijo = 2000;
					consumoAnual += (valorM3 * consumoM3[a][b]) + cargofijo;
					consumoAguaAnual += consumoM3[a][b];
				} else if (consumoM3[a][b] >= 12) {
					valorM3 = 120;
					consumoAnual += (valorM3 * consumoM3[a][b]) * 1.1;
					consumoAguaAnual += consumoM3[a][b];
				}
				if (a >= 0 && a < 4) {
					pisos[0] += consumoM3[a][b];
				} else if (a >= 4 && a < 8) {
					pisos[1] += consumoM3[a][b];
				} else if (a >= 8 && a < 12) {
					pisos[2] += consumoM3[a][b];
				} else if (a >= 12 && a < 16) {
					pisos[3] += consumoM3[a][b];
				} else if (a >= 16 && a < 20) {
					pisos[4] += consumoM3[a][b];
				} else if (a >= 20 && a < 24) {
					pisos[5] += consumoM3[a][b];
				} else if (a >= 24 && a < 28) {
					pisos[6] += consumoM3[a][b];
				} else if (a >= 28 && a < 32) {
					pisos[7] += consumoM3[a][b];
				}
				if (b == 0) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 1) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 2) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 3) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 4) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 5) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 6) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 7) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 8) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 9) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 10) {
					consumoM3Mes[b] += consumoM3[a][b];
				} else if (b == 11) {
					consumoM3Mes[b] += consumoM3[a][b];
				}
				for (int o = 0; o < 12; o++) {
					if (consumoM3Mes[o] > maxMesCon) {
						maxMes = o + 1;
						maxMesCon = consumoM3Mes[o];
					}
				}
			}
		}
		imprimirInforme(consumoAnual, consumoAguaAnual, maxMes, maxMesCon, pisos);
	}
	
	public static void imprimirInforme(double consumoAnual, double consumoAguaAnual, int maxMes, double maxMesCon, int pisos[]){
		System.out.println("Informe Anual de Agua");
		System.out.println();
		System.out.println("Consumo Anual del Edificio ($)    : " + consumoAnual);
		System.out.println("Consumo Anual del Edificio (m3)   : " + consumoAguaAnual);
		System.out.println(
				"Mes con Mayor Consumo de Agua (m3): Mes " + maxMes + "\t con " + maxMesCon + " m3");
		System.out.println("Consumo Anual por Piso:");
		System.out.println("Piso \t Consumo anual");
		for (int k = 0; k < 8; k++) {
			System.out.println((k + 1) + " \t " + pisos[k]);
		}
		System.out.println();
	}
	
	
	public static double validarNumero(Scanner leer) {
		boolean invalido;
		double num = 0;
		do {
			invalido = true;
			System.out.println("Ingrese un Numero");
			String read = leer.next();
			if (read.matches("[0-9]+")) {
				num = Double.valueOf(read);
				if (num >= 0) {
					invalido = false;
				}
			} else {
				if (read.matches("[0-9]+\\.[0-9]+")) {
					num = Double.valueOf(read);
					if (num >= 0) {
						invalido = false;
					}
				}
			}
			if (invalido) {
				System.out.println("Debe ingresar un numero");
			}
		} while (invalido);
		return num;
	}
}
