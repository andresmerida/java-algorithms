package dev.amerida.algoritms.common.fibonacci_serie;

public class FibonacciSequence {

    public int[] fibonacciIterative(int n) {
        if (n <= 1) return new int[]{0};
        if (n == 2) return new int[]{0, 1};

        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }

    public int[] fibonacciRecursive(int n) {
        int[] fibonacci = new int[n];
        for (int i = 0; i < n; i++) {
            fibonacci[i] = fib(i);
        }

        return fibonacci;
    }

    private int fib(int n) {
        return n < 2 ? n : fib(n - 1) + fib(n - 2);
    }

    public int getLastFibonacciSequence(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;

        int prev = 0, curr = 1;
        for (int i = 2; i < n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }
}
