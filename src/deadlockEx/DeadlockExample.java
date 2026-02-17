package deadlockEx;

public class DeadlockExample {
    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            synchronized (obj1) {
                System.out.println("Thread 1:  Holding lock 1");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: waiting for lock 2");

                synchronized (obj2) {
                    System.out.println("Thread 2: Holding lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (obj2) {
                System.out.println("Thread 2: Holding lock 2");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Waiting for lock 2");

                synchronized (obj1) {
                    System.out.println("Thread 1: Waiting for lock 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
