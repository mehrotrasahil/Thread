package synchronizedEx;

/**
 * This class demonstrates the use of synchronization in Java to handle
 * multiple threads accessing and modifying a shared resource (a counter).
 * 
 * Key Concepts:
 * - When multiple threads try to modify the same object simultaneously, 
 *   there can be unexpected results (race conditions). To prevent this, 
 *   we use synchronization to make sure only one thread can modify the shared resource at a time.
 * - In this example, we create two threads that both try to increment the same counter.
 *   Without synchronization, the final counter value may not be as expected.
 * - The `Counter` class contains the shared resource (the count variable) and 
 *   its `increment()` method is synchronized to ensure thread safety.
 * 
 * Steps:
 * 1. We create two threads (`tc1` and `tc2`) that both call the `increment()` method of the `Counter` object.
 * 2. The `increment()` method uses a synchronized block to ensure that only one thread 
 *    can increment the counter at a time.
 * 3. After both threads finish execution, we print the final value of the counter.
 * 
 * Expected Output:
 * - The counter should be incremented 2000 times (1000 times by each thread).
 * - The use of synchronization ensures that the final output is correct.
 */
public class SynchronizedExample {
    public static void main(String[] args) {
        // Create a shared Counter object that both threads will modify
        Counter counter = new Counter();

        // Create two threads and pass the same Counter object to both
        ThreadCreate tc1 = new ThreadCreate(counter);
        ThreadCreate tc2 = new ThreadCreate(counter);

        // Start both threads, allowing them to run simultaneously
        tc1.start();
        tc2.start();

        // Wait for both threads to finish execution using the join() method
        try {
            tc1.join();
            tc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After both threads have finished, print the final value of the counter
        System.out.println("Counter value: " + counter.getCount());
    }
}
