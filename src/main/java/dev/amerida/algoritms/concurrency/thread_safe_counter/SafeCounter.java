package dev.amerida.algoritms.concurrency.thread_safe_counter;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public void decrement() {
        counter.decrementAndGet();
    }

    public int getValue() {
        return counter.get();
    }

    static void main() throws InterruptedException {
        SafeCounter atomicCounter = new SafeCounter();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicCounter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();      // Wait for all threads to finish
        }

        IO.println("Final counter value: " + atomicCounter.getValue());
    }
}
