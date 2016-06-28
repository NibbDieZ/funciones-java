/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nibb10
 */
import java.util.*;

public class EjercicioFunciones1 {
    public static void main(String[] args) {
        int i;
        String resp;
        float ptjes[] = new float[6];
        float matrizPorc[][] = new float[10][7];
        
        Scanner leer = new Scanner (System.in);
        llenarMatrizPorc(matrizPorc,leer);
        do {
            leerPtjes(ptjes);
            for (i=0;i<10;i++)
                if (calcPond(ptjes,matrizPorc,i)){
                    System.out.println("puede postular a la carrera "+(i+1));
            }
            System.out.println("Desea otra simulación: ");
            resp = leer.next();
        }while(resp!="no");
}
	public static void llenarMatrizPorc(float matrizPorc[][], Scanner leer) {
		System.out.println("Ingrese Requisitos para cada Carrera");
		System.out.println("Estos porcentajes deben ser multiplos de 5 entre 10 y 60");
		System.out.println("La suma de ellos (exluyendo Historia o Ciencias) no puede superar el 100%");
		System.out.println("E Historia y Ciencias deben tener el mismo requisito a menos q uno de estos sea 0");
		for (int i = 0; i < 10; i++) {
			float porcentaje = 0;
			boolean electivo = false;
			System.out.println("Ingrese Requisitos de Carrera " + (i + 1));
			do {
				do {
					porcentaje = 0;
					for (int j = 0; j < 7; j++) {
						switch (j) {
						case 0:
							System.out.println("Porcentaje NEM");
							break;
						case 1:
							System.out.println("Porcentaje Ranking");
							break;
						case 2:
							System.out.println("Porcentaje PSU Lenguaje");
							break;
						case 3:
							System.out.println("Porcentaje PSU Matematica");
							break;
						case 4:
							System.out.println("Porcentaje PSU Historia");
							break;
						case 5:
							System.out.println("Porcentaje PSU Ciencias");
							break;
						case 6:
							System.out.println("Puntaje Ultimo Matriculado Año Anterior");
							break;
						}

						if (j < 4) {
							do {
								do {
									System.out.println("Ingrese Porcentaje");
									matrizPorc[i][j] = leer.nextFloat();
								} while (matrizPorc[i][j] % 5 != 0);
							} while (matrizPorc[i][j] > 60 || matrizPorc[i][j] < 10);
						} else {
							if (j == 4 || j == 5) {
								do {
									do {
										System.out.println("Ingrese Porcentaje");
										matrizPorc[i][j] = leer.nextFloat();
										if (matrizPorc[i][j] == 0) {
											electivo = true;
											break;
										}
									} while (matrizPorc[i][j] % 5 != 0);
									if (matrizPorc[i][j] == 0) {
										break;
									}
								} while (matrizPorc[i][j] > 60 || matrizPorc[i][j] < 0);
							} else {
								do {
									System.out.println("Ingrese Puntaje (Entre 450 y 850)");
									matrizPorc[i][j] = leer.nextFloat();
								} while (matrizPorc[i][j] > 850 || matrizPorc[i][j] < 450);
							}
						}
						if (j < 4) {
							porcentaje += matrizPorc[i][j];
						}
						if (matrizPorc[i][4] == matrizPorc[i][5]) {
							electivo = true;
						}

					}
				} while (electivo == false);
			} while (porcentaje + matrizPorc[i][4] != 100 && porcentaje + matrizPorc[i][5] != 100);
		}
	}

	public static void leerPtjes(float ptjes[]) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese Puntajes Obtenidos");
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				System.out.println("Puntaje NEM");
				break;
			case 1:
				System.out.println("Puntaje Ranking");
				break;
			case 2:
				System.out.println("Puntaje PSU Lenguaje");
				break;
			case 3:
				System.out.println("Puntaje PSU Matematica");
				break;
			case 4:
				System.out.println("Puntaje PSU Historia");
				break;
			case 5:
				System.out.println("Puntaje PSU Ciencias");
				break;
			}
			ptjes[i] = leer.nextFloat();
			while (ptjes[i] > 850 || ptjes[i] < 0) {
				System.out.println("El puntaje ingresado esta fuera del rango");
				ptjes[i] = leer.nextFloat();
			}
		}
	}

	public static boolean calcPond(float ptjes[], float matrizPorc[][], int i) {
		float ponderado = 0;
		for (int j = 0; j < 4; j++) {
			ponderado += (ptjes[j] / 100 * matrizPorc[i][j]);
		}
		if (matrizPorc[i][4] > 0 && matrizPorc[i][5] == 0) {
			ponderado += (ptjes[4] / 100 * matrizPorc[i][4]);
		} else {
			if (matrizPorc[i][5] > 0 && matrizPorc[i][4] == 0) {
				ponderado += (ptjes[4] / 100 * matrizPorc[i][4]);
			} else {
				if (ptjes[4] > ptjes[5]) {
					ponderado += (ptjes[4] / 100 * matrizPorc[i][4]);
				} else {
					ponderado += (ptjes[5] / 100 * matrizPorc[i][5]);
				}
			}
		}
		if (ponderado >= matrizPorc[i][6]) {
			return true;
		} else {
			return false;
		}
	}
}