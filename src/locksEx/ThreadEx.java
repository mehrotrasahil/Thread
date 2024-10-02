package locksEx;

/**
 * The ThreadEx class serves as the entry point for the application. 
 * It creates an instance of the BankAccount class and starts two threads 
 * that attempt to withdraw money concurrently from the same account.
 */
public class ThreadEx {
    public static void main(String[] args) {
        // Creating an instance of BankAccount with an initial balance of 100.
        BankAccount bankAccount = new BankAccount();

        // Creating a task that represents the withdrawal process.
        // Both threads will execute this task, attempting to withdraw 50 units of money.
        Runnable task = () -> bankAccount.withdraw(50);

        // Creating two threads, each representing a different customer trying to withdraw money.
        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        // Starting both threads. They will execute the withdraw method concurrently.
        t1.start();
        t2.start();
    }
}