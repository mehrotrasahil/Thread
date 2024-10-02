package synchronizedEx;

/**
 * This class represents the shared resource (the counter) that will be accessed
 * by multiple threads.
 * 
 * Key Concepts:
 * - The `count` variable is the shared resource.
 * - The `increment()` method is synchronized to ensure that only one thread can 
 *   modify the `count` variable at a time. This prevents race conditions.
 * 
 * Synchronization Approaches:
 * 1. **Synchronized Method**: Uncommenting the `synchronized` keyword in the method signature 
 *    would synchronize the entire method. This ensures that only one thread can execute the 
 *    entire method at a time.
 * 2. **Synchronized Block**: Instead of synchronizing the whole method, we use a 
 *    synchronized block within the `increment()` method. This allows us to synchronize only 
 *    the critical section (the part that modifies the shared resource), which can improve performance.
 * 
 * Methods:
 * - `increment()`: Increases the value of `count` by 1. It is synchronized to ensure thread safety.
 * - `getCount()`: Returns the current value of `count`.
 */
public class Counter {
    private int count = 0;

    // Synchronized block within the method ensures that only one thread at a time
    // can execute the code that modifies the shared variable "count"
    public void increment() {
        synchronized (this) {  // "this" refers to the Counter object
            count++;           // Only one thread at a time can increment the count
        }
    }

    // Getter method to return the current value of the counter
    public int getCount() {
        return count;
    }
}
