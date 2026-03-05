package dev.amerida.algoritms.concurrency.executor_service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceFuture {
    static void main() {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            Future<Integer> future = executor.submit(() -> {
                Thread.sleep(3000);
                return 42;
            });
            // 1. Check if done
            if (future.isDone()) {
                IO.println("Task completed!");
            }

            // 2. Get result
            Integer result = future.get();
            IO.println("Result: " + result);

            // 3. Get with timeout
            Integer result2 = future.get(5, TimeUnit.SECONDS);

            // 4. Cancel task
            boolean cancelled = future.cancel(true);
            if (future.isCancelled()) {
                IO.println("Task cancelled!");
            }
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
