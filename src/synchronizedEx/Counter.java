package synchronizedEx;

public class Counter {
    private int count = 0;

/*     public synchronized void increment(){    //This will synchronized the whole method
        count++;
    } */

    public void increment(){
        synchronized(this){    // This will synchronized a block of the method
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
