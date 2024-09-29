/**
 * This class demonstrates the use of thread priorities in Java.
 * 
 * Key Concepts:
 * - Each thread can have a priority value between 1 (MIN_PRIORITY) and 10 (MAX_PRIORITY),
 *   with 5 (NORM_PRIORITY) being the default priority.
 * - Higher priority threads are given preference by the thread scheduler to run more often
 *   than lower priority threads, but it's not guaranteed as thread scheduling depends on 
 *   the underlying operating system.
 *
 * What this code does:
 * - We create three threads (`t1`, `t2`, and `t3`), each with different priorities:
 *   - `t1` has the highest priority (MAX_PRIORITY).
 *   - `t2` has the lowest priority (MIN_PRIORITY).
 *   - `t3` has the normal priority (NORM_PRIORITY).
 * - Each thread executes the same task, which involves building a large string one million times.
 *   This simulates a CPU-intensive task that takes some time to complete.
 * - While each thread is running, it prints its name, priority, and the current iteration count.
 * - The priorities are used by the thread scheduler to decide how much CPU time to allocate 
 *   to each thread. Threads with higher priority may get more CPU time.
 *
 * Key Methods:
 * - `start()`: This method starts a new thread and calls the `run()` method.
 * - `run()`: This is the code that will be executed by the thread when it starts.
 * - `setPriority()`: This method sets the priority for a thread (1 to 10).
 * - `getPriority()`: This method retrieves the priority of the current thread.
 * 
 * The program demonstrates how different priorities can influence thread execution,
 * although the final behavior depends on the operating system's thread scheduler.
 */
public class PriorityThread extends Thread {

    public PriorityThread(String name) {
        super(name);  // Call to the superclass constructor to set the thread's name
    }

    @Override
    public void run() {
        // The run() method contains the code that will be executed when the thread starts
        for (int i = 0; i < 5; i++) {
            // StringBuilder is used for better performance when appending strings in a loop
            StringBuilder str = new StringBuilder(); 
            for (int j = 0; j < 1000000; j++) {
                str.append("q");  // Append "q" one million times (simulating a heavy task)
            }

            // Print the name of the thread, its priority, and the current iteration count
            System.out.println(Thread.currentThread().getName() + " - priority: " 
                + Thread.currentThread().getPriority() + " - count: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create three threads with different names
        PriorityThread t1 = new PriorityThread("High Priority");
        PriorityThread t2 = new PriorityThread("Low Priority");
        PriorityThread t3 = new PriorityThread("Normal Priority");

        // Setting different priorities for the threads
        t1.setPriority(Thread.MAX_PRIORITY);  // Set t1 to maximum priority (10)
        t2.setPriority(Thread.MIN_PRIORITY);  // Set t2 to minimum priority (1)
        t3.setPriority(Thread.NORM_PRIORITY); // Set t3 to normal priority (5)

        // Start all the threads
        t1.start();  // Starts the thread t1 (with highest priority)
        t2.start();  // Starts the thread t2 (with lowest priority)
        t3.start();  // Starts the thread t3 (with normal priority)

        // Main thread ends here, but the created threads continue to run concurrently
    }
}
