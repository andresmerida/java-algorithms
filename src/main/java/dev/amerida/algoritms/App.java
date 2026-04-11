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
        //fillArray(arr); It was disabled to avoid the user to enter the same number
        showArray(arr);
        printMaxMin(arr);
        printSumArray(arr);
        IO.println();
        printPyramidOddEven(4);
        IO.println();
        fillMatrix(5);
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

    /**
     * 1
     * 2 3
     * 6 5 4
     * 7 8 9 10
     * @param n number of rows
     */
    public static void printPyramidOddEven(int n) {
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            int minNumber = counter;
            int maxNumber = counter + i - 1;
            if (i % 2 == 0) {
                for (int j = minNumber; j <= maxNumber; j++) {
                    System.out.print(j + (j == maxNumber ? "" : " "));
                }
            } else {
                for (int j = maxNumber; j >= minNumber; j--) {
                    System.out.print(j + (j == minNumber ? "" : " "));
                }
            }
            System.out.println();
            counter = maxNumber + 1;
        }
    }

    public static void fillMatrix(int n) {
        int sizeMatrix = 5;
        int[][] matrix = new int[sizeMatrix][sizeMatrix];

        int counter = 1;
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int number : ints) {
                System.out.print((number < 10 ? "0" + number : number) + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] arr) {
        IO.println(Arrays.toString(arr));
    }
}
