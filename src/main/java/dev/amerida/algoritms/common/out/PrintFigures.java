package dev.amerida.algoritms.common.out;

public class PrintFigures {
    static void main() {
        printRectangle();
        IO.println();

        printTriangle();
        IO.println();

        printTriangleReverse();
        IO.println();

        printPyramid();
        IO.println();

        printPyramidReversed(4);
        IO.println();

        printComet(7);
    }

    /**
     *  *
     *  **
     *  ***
     *  ****
     *  *****
     */
    private static void printTriangle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * *****
     * ****
     * ***
     * **
     * *
     */
    private static void printTriangleReverse() {
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *  *****
     *  *****
     *  *****
     *  *****
     *  *****
     */
    private static void printRectangle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *    *
     *   ***
     *  *****
     * *******
     */
    private static void printPyramid() {
        int rows = 4; // Number of levels in the pyramid

        for (int i = 1; i <= rows; i++) {
            // 1. Print leading spaces to center the stars
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }

            // 2. Print stars (odd numbers: 1, 3, 5, 7, 9)
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            // 3. Move to the next line after each row
            System.out.println();
        }
    }

    /**
     * *******
     *  *****
     *   ***
     *    *
     */
    private static void printPyramidReversed(int rows) {

        for (int i = rows; i >= 1; i--) {
            // 1. Print leading spaces to center the stars
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }

            // 2. Print stars (odd numbers: 1, 3, 5, 7, 9)
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            // 3. Move to the next line after each row
            System.out.println();
        }
    }

    /**
     *    *
     *   ***
     *  *****
     * *******
     *  *****
     *   ***
     *    *
     */
    private static void printComet(int levels) {
        int rowsTriangle = levels/2 + 1;

        for (int i = 1; i <= rowsTriangle; i++) {
            // 1. Print leading spaces to center the stars
            for (int j = i; j < rowsTriangle; j++) {
                System.out.print(" ");
            }

            // 2. Print stars (odd numbers: 1, 3, 5, 7, 9)
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            // 3. Move to the next line after each row
            System.out.println();
        }

        for (int i = rowsTriangle - 1; i >= 1; i--) {
            // 1. Print leading spaces to center the stars
            for (int j = i; j <= rowsTriangle - 1; j++) {
                System.out.print(" ");
            }

            // 2. Print stars (odd numbers: 1, 3, 5, 7, 9)
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            // 3. Move to the next line after each row
            System.out.println();
        }
    }
}
