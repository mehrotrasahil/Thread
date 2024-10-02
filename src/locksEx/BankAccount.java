
// The BankAccount class represents a bank account with synchronized withdrawal capabilities.
package locksEx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The BankAccount class simulates a bank account with a balance 
 * and provides a method to withdraw money while ensuring thread safety 
 * using a ReentrantLock. 
 */
public class BankAccount {
    private int balance = 100; // Initial balance of the bank account.

    // A ReentrantLock with fairness policy to ensure that the longest waiting thread gets access first.
    private final Lock lock = new ReentrantLock(true);

    /**
     * Attempts to withdraw a specified amount from the account.
     * @param amount The amount of money to withdraw.
     */
    public void withdraw(int amount) {
        // Logging the thread's attempt to withdraw money.
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw money: " + amount);
        
        try {
            // Try to acquire the lock without blocking. If the lock is not available, return false.
            if (lock.tryLock()) {
                // Check if sufficient balance is available for withdrawal.
                if (balance >= amount) {
                    try {
                        // Simulating a delay in processing the withdrawal.
                        System.out.println(Thread.currentThread().getName() + " processing the withdraw: ");
                        Thread.sleep(3000); // Simulate time taken for processing.
                        
                        // Deducting the amount from the balance.
                        balance -= amount;
                        // Logging the completion of the withdrawal and the remaining balance.
                        System.out.println(Thread.currentThread().getName() + " withdraw completed. Remaining balance: " + balance);
                    } catch (Exception e) {
                        // Handle any exception that occurs during the withdrawal process.
                        System.err.println("Exception occurred: " + e.getMessage());
                        Thread.currentThread().interrupt(); // Restore interrupted status.
                    } finally {
                        // Ensure the lock is released after processing the withdrawal.
                        lock.unlock();
                    }
                } else {
                    // Log if there is not enough balance for the withdrawal.
                    System.out.println(Thread.currentThread().getName() + " Not enough balance.");
                }
            } else {
                // If the lock could not be acquired, log the message and indicate retry later.
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock. Will try again later.");
            }
        } catch (Exception e) {
            // Log any exceptions that occur in the withdrawal process.
            e.printStackTrace();
            Thread.currentThread().interrupt(); // Restore interrupted status.
        }
    }
}