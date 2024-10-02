package raceCondition;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ThreadCreate threadCreate1 = new ThreadCreate(counter);
        ThreadCreate threadCreate2 = new ThreadCreate(counter);

        threadCreate1.start();
        threadCreate2.start();

        try{
            threadCreate1.join();;
            threadCreate2.join();
        }catch(InterruptedException ie){
            System.err.println("Exception occur " + ie.getMessage());

        }

        System.out.println("Counter value: " + counter.getCount());
        
    }
    
}
