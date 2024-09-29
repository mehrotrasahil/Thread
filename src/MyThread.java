/**
 * This example demonstrates the different states of a thread in Java.
 *
 * When a thread object is created but not yet started, it is in the NEW state. 
 * This means the thread has been initialized but is not yet eligible to run.
 *
 * @Override
 * public void run(){
 * }
 *
 * public static void main(String[] args) {
 *     MyThread t1 = new MyThread();
 *     System.out.println(t1.getState()); // Output: NEW
 * }
 * 
 * After calling the start() method on the thread, it moves to the RUNNABLE state.
 * This means the thread is now ready to execute, and the JVM will schedule it 
 * for execution as per availability of CPU.
 *
 * t1.start();
 * System.out.println("After starting the thread: " + t1.getState()); // Output: RUNNABLE
 *
 * When we call Thread.sleep(20000) inside the thread, the thread moves to the TIMED_WAITING state.
 * This indicates that the thread is waiting for a specified time (20 seconds in this case) 
 * before it can resume execution.
 * 
 * Thread.sleep(100); // Pause the main thread for 100 milliseconds to allow t1 to run
 * System.out.println("After putting the thread in sleep: " + t1.getState()); // Output: TIMED_WAITING
 *
 * The join() method ensures that the main thread waits for the thread t1 to finish 
 * before it continues its execution. Once the thread completes, it moves to the TERMINATED state,
 * meaning its execution has finished.
 * 
 * t1.join();
 * System.out.println("After using join: " + t1.getState()); // Output: TERMINATED
 */

 public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running");
        try {
            Thread.sleep(2000);  // Simulating a task by making the thread sleep for 20 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        
        // Thread is in the NEW state after creation but before calling start()
        System.out.println("Before starting the thread: " + t1.getState()); // Output: NEW

        t1.start();
        
        // After calling start(), the thread moves to the RUNNABLE state
        System.out.println("After starting the thread: " + t1.getState()); // Output: RUNNABLE

        // Pause the main thread to give t1 a chance to start and possibly enter TIMED_WAITING
        Thread.sleep(100);
        
        // Thread should be in TIMED_WAITING due to sleep() in the run method
        System.out.println("After putting the thread in sleep: " + t1.getState()); // Output: TIMED_WAITING

        // The main thread waits for t1 to finish its execution (join waits for t1 to die)
        t1.join();

        // After t1 finishes, it moves to the TERMINATED state
        System.out.println("After using join: " + t1.getState()); // Output: TERMINATED
    }
}
