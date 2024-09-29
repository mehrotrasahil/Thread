/**
 * This class demonstrates how to interrupt a thread in Java.
 * 
 * Key Concepts:
 * - A thread can be interrupted using the `interrupt()` method. This method does not 
 *   stop the thread immediately but instead sets an "interrupt flag," signaling that 
 *   the thread has been interrupted.
 * - If a thread is in a sleep or wait state, it will throw an `InterruptedException` 
 *   when interrupted. This allows the thread to handle interruptions gracefully.
 *
 * What this code does:
 * - We create a thread (`t1`) by extending the `Thread` class and overriding its `run()` method.
 * - In the `run()` method, the thread is put to sleep for 2 seconds using `Thread.sleep(2000)`. 
 *   This simulates the thread being in a waiting state.
 * - Before the sleep period finishes, the thread is interrupted by calling `t1.interrupt()`. 
 *   This interruption causes the `InterruptedException` to be thrown and caught in the `catch` block.
 * - After the thread is interrupted, it prints a message indicating that it has been interrupted.
 * - Finally, after the thread completes execution, the main thread prints a message.
 *
 * Key Methods:
 * - `start()`: This method starts the thread and calls the `run()` method, putting the thread 
 *   in the `RUNNABLE` state.
 * - `interrupt()`: This method interrupts the thread, setting an interrupt flag. If the thread 
 *   is sleeping or waiting, it throws `InterruptedException`.
 * - `sleep()`: This method pauses the thread for a specified time (in milliseconds). In this example, 
 *   the thread is set to sleep for 2 seconds.
 * - `InterruptedException`: This exception is thrown when a thread is interrupted during sleep or waiting.
 *
 * The program shows how a thread can be interrupted while sleeping and how it handles the interruption.
 */
public class InterruptThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running.....");
        try {
            // Pausing the thread execution for 2 seconds
            Thread.sleep(2000);  
        } catch (InterruptedException e) {
            // If the thread is interrupted while sleeping, this block will execute
            System.out.println("Thread is interrupted: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Creating a thread object
        InterruptThread t1 = new InterruptThread();
        
        // Starting the thread (puts it in the RUNNABLE state and executes run() method)
        t1.start();
        
        // Interrupting the thread (causes an InterruptedException in the thread)
        t1.interrupt();
        
        // This statement will execute after the thread completes or is interrupted
        System.out.println("Main thread executes after waiting:");
    }
}
