package synchronizedEx;

/**
 * This class represents a thread that will increment the shared counter.
 * 
 * Key Concepts:
 * - Each instance of `ThreadCreate` is passed the same `Counter` object.
 * - In the `run()` method, the thread increments the counter 1000 times.
 * - Since multiple threads are accessing the same `Counter` object, synchronization is 
 *   necessary to avoid race conditions.
 * 
 * Methods:
 * - The `run()` method is the entry point of the thread. It contains a loop that 
 *   increments the counter 1000 times.
 * - By calling the `counter.increment()` method inside the loop, each thread 
 *   tries to modify the shared counter.
 */
public class ThreadCreate extends Thread {
    private Counter counter;

    // Constructor takes the shared Counter object
    public ThreadCreate(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // Increment the counter 1000 times
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
