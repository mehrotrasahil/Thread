/**
 * This example demonstrates different methods of the Thread class in Java:
 * 
 *  - run(): This method contains the code that defines the behavior of the thread.
 *            When a thread is started, the code inside the run() method is executed.
 *            You should override this method to specify the task the thread should perform.
 *
 *  - start(): This method starts the thread and puts it in the "RUNNABLE" state. 
 *             Internally, it calls the run() method, allowing the thread to begin execution.
 *             Unlike calling run() directly, start() enables actual multithreading by creating
 *             a new thread of execution.
 *
 *  - sleep(): This method pauses the execution of the current thread for a specified time
 *             (in milliseconds). During this time, the thread enters the "TIMED_WAITING" state
 *             and resumes after the specified sleep duration, allowing other threads to run.
 *
 *  - join(): This method forces the current thread to wait until the thread on which join() is called
 *            has completed execution (i.e., it reaches the "TERMINATED" state). This ensures that
 *            the calling thread will not continue until the joined thread finishes.
 */

 public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running.....");
        try {
            // Pausing the thread execution for 5 seconds
            Thread.sleep(5000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        
        // Starting the thread (puts it in RUNNABLE state and runs run() method)
        t1.start();
        
        // Main thread waits until t1 finishes execution
        t1.join();
        
        // This statement will execute after t1 completes
        System.out.println("Main thread executes after waiting:");
    }
}
