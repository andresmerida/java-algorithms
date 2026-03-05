package dev.amerida.algoritms.concurrency.executor_service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

    static void main(String[] args) {

        // Fixed Thread Pools. Use Case: You know your workload and want a consistent thread count
        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i < 20; i++) {
                final int taskId = i;
                executorService.submit(() -> {
                    IO.println("Task: " + taskId + " is running on thread: " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    return null;
                });
            }
        }
        IO.println();

        // Cached Thread Pools. Best for: Web servers, I/O operations, unpredictable loads
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 100; i++) {
                final int taskId = i;
                executorService.submit(() -> {
                    IO.println("Task: " + taskId + " is running on thread: " + Thread.currentThread().getName());
                    Thread.sleep(100);
                    return null;
                });
            }
        }
        IO.println();

        // Single Thread Executor. Use Case: Tasks must be executed sequentially in order
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            executorService.submit(() -> IO.println("Task: 1 - is running first"));
            executorService.submit(() -> IO.println("Task: 2 - is running second"));
            executorService.submit(() -> IO.println("Task: 3 - is running third"));
            executorService.submit(() -> IO.println("Task: 4 - is running fourth"));
            executorService.submit(() -> IO.println("Task: 5 - is running fifth"));
        }

        // Scheduled Thread Pools. Use Case: Tasks that need to be executed after delay or periodically
        // One-time Delayed Task
        try (ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1)) {
            scheduledExecutorService.schedule(() -> IO.println("Task: 1 - is running after 5 seconds"), 5, TimeUnit.SECONDS);
        }
        IO.println();

        // Periodic Task (Fixed Delayed Task)
        // Waits 2 seconds AFTER previous task completes
        try (ScheduledExecutorService scheduledWithFixedDelay = Executors.newScheduledThreadPool(1)) {
            scheduledWithFixedDelay.scheduleWithFixedDelay(() -> {
                IO.println("Task starting at: " + LocalTime.now());
                try {
                    Thread.sleep(3000);     // the task takes 3 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                IO.println("Task ending at: " + LocalTime.now());
                // then waits 2 seconds before the next execution
            }, 0, 2, TimeUnit.SECONDS);
        }

        IO.println();
    }
}
