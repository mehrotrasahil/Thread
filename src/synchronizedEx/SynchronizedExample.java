package synchronizedEx;

public class SynchronizedExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        ThreadCreate tc1 = new ThreadCreate(counter);
        ThreadCreate tc2 = new ThreadCreate(counter);

        tc1.start();
        tc2.start();

        try {
            tc1.join();
            tc2.join();
        } catch (InterruptedException e) {
            // TODO: handle exception
        }

        System.out.println("Counter value: " + counter.getCount());
    }
}
