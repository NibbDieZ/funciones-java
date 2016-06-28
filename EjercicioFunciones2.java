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

public class EjercicioFunciones2 {
	public static void main(String[] args) {
		
		Scanner intro = new Scanner(System.in);
		System.out.println("Ingrese tamaño del Vector");
		int n = intro.nextInt();
		while (n < 1) {
			System.out.println("El tamaño no puede ser menor a 1");
			n = intro.nextInt();
		}
		int[] vector = new int[n];
		System.out.println("Ingrese datos del Vector");
		funcion1(vector, n);
		funcion4(vector, n);
		System.out.println("El Mayor es " + vector[n - 1]);
	}
	
	public static void funcion1(int[] arreglo, int valor) { 
		int i = 0;
		Scanner objeto = new Scanner(System.in);
		while (i < valor) {
			arreglo[i] = objeto.nextInt();
			i++;
		}
	}

	public static void funcion4(int[] arreglo, int valor) { 
		int i = 0, j, x;
		while (i < valor) {
			j = i + 1;
			while (j < valor) {
				if (arreglo[i] > arreglo[j]) {
					x = arreglo[i];
					arreglo[i] = arreglo[j];
					arreglo[j] = x;
				}
				j++;
			}
			i++;
		}
	}

}