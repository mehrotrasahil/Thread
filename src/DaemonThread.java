/**
 * This class demonstrates the use of daemon threads in Java.
 * 
 * Key Concepts:
 * - Daemon threads are low-priority threads that run in the background 
 *   and do not prevent the JVM from exiting when the program finishes. 
 * - When all user threads (non-daemon threads) have finished execution, 
 *   the JVM will terminate, and daemon threads will be killed.
 * - Daemon threads are typically used for background tasks, such as 
 *   garbage collection, monitoring, or handling resource management.
 *
 * What this code does:
 * - We create a class `DaemonThread` that extends the `Thread` class and 
 *   overrides the `run()` method to execute an infinite loop that prints 
 *   "Thread is running..." continuously.
 * - In the `main()` method, we create an instance of `DaemonThread` (named `t1`).
 * - We set `t1` as a daemon thread using `t1.setDaemon(true)`. This means that 
 *   this thread will run in the background and will not block the JVM from exiting.
 * - The thread is started with `t1.start()`, which puts it into the RUNNABLE state 
 *   and begins executing the `run()` method.
 * - The main thread prints "Main thread..." immediately after starting the daemon thread.
 *
 * Key Methods:
 * - `setDaemon(true)`: This method marks the thread as a daemon thread. 
 *   Daemon threads will terminate when all user threads have completed.
 * - `start()`: This method starts the thread and calls the `run()` method.
 * - `run()`: This method contains the code to be executed by the thread. 
 *   In this case, it runs an infinite loop.
 *
 * Note: Since `t1` is a daemon thread running an infinite loop, the main thread 
 * will exit immediately after printing "Main thread...". 
 * This will cause the JVM to terminate, and the daemon thread will be abruptly stopped.
 */
public class DaemonThread extends Thread {

    @Override
    public void run() {
        // Infinite loop to continuously print a message
        while (true) {
            System.out.println("Thread is running...");
        }
    } 

    public static void main(String[] args) {
        // Create an instance of DaemonThread
        DaemonThread t1 = new DaemonThread();
        
        // Set the thread as a daemon thread
        t1.setDaemon(true);
        
        // Start the daemon thread
        t1.start();
        
        // Print message from the main thread
        System.out.println("Main thread..");
    }
}
