package volatilKey;

class FlagExample {
    boolean flag = true;
    // volatile boolean flag = true;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class VolatileEx {

    public static void main(String[] args) throws InterruptedException {

        FlagExample flagExample = new FlagExample();

        Runnable task1 = () -> {
            while (flagExample.flag) {
                System.out.println("Hello");
            }

            System.out.println("Thread one: flag changes to false");
        };

        Runnable task2 = () -> {

            try {
                Thread.sleep(200);
                flagExample.setFlag(false);
                System.out.println("flag set to false");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
