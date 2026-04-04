package dev.amerida.algoritms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Desarrolle un programa que permita cargar numeros enteros no repetidos a un arreglo de tamaño 10.
 * A continuacion debera determinar el maximo y minimo de los numeros del arreglo. Tambien indicar cuantos valores no se encuentran presentes
 * e indicar la suma de los numeros del arreglo.
 *
 */
public class App {
    static void main( String[] args ) {
        int[] arr = new int[4]; // [5, 8, 50, 3] , [0,0,0,0]
        fillArray(arr);
        showArray(arr);
        printMaxMin(arr);
        printSumArray(arr);
    }

    private static void printSumArray(int[] arr) {
        int sum = 0;
        for (int number : arr) {
            sum = sum + number;
        }
        IO.println("The sum of the array is: " + sum);
    }

    private static void printMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        IO.println("The MAX value of the array is: " + max);
        IO.println("The MIN value of the array is: " + min);
    }

    public static void fillArray(int[] arr) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        while (counter < 4) {
            System.out.print("Enter a number: ");
            int numberEntered = scanner.nextInt();

            if (!containsNumber(arr, counter, numberEntered)) {
                arr[counter] = numberEntered;
                counter++;
            } else {
                System.out.println("Number " + numberEntered+ " already exists in the array");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static boolean containsNumber(int[] arr, int limit, int number) {
        for (int i = 0; i < limit; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }

    public static void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                IO.print("[" + arr[i]);
            } else {
                IO.print(", " + arr[i]);
            }
        }
        IO.println("]");
    }

    public static void printArray(int[] arr) {
        IO.println(Arrays.toString(arr));
    }
}
