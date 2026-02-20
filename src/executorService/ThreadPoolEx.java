
/* 
ExecutorService is:

A thread pool manager.

It: Creates threads, Reuses them, Assigns tasks, Manages lifecycle

You don’t manually create threads anymore.

Example Exaplanation.

What Happens Here?
Executors.newFixedThreadPool(2);
Means:
-> Create only 2 threads in pool.
Then you submit 4 tasks.

How?
Step by step:
1️⃣ First 2 tasks run immediately (2 threads available)
2️⃣ Remaining 2 tasks wait in queue
3️⃣ When a thread finishes → it picks next task

Threads are reused.

No new threads created.

*/

package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);

        executorService.shutdown();
    }
}
