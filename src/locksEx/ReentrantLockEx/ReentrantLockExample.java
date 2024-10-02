package locksEx.ReentrantLockEx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class demonstrates the use of `ReentrantLock` in Java.
 * 
 * Key Concepts:
 * - `ReentrantLock` is part of Java's concurrent utilities, allowing more control over locking 
 *   mechanisms compared to the `synchronized` keyword.
 * - A `ReentrantLock` allows a thread to lock the same resource multiple times (reentrant).
 * - In this example, the `outerMethod()` and `innerMethod()` both acquire the same lock. 
 *   A thread that holds a lock can acquire it again without getting blocked (reentrancy).
 * 
 * Breakdown:
 * 1. `outerMethod()` locks the resource before calling `innerMethod()`.
 * 2. `innerMethod()` tries to lock the same resource, but because of reentrancy, 
 *    the thread can re-acquire the lock without deadlocking.
 * 3. Both methods release the lock once their operations are completed.
 * 
 * Lock Mechanism:
 * - `lock.lock()`: Acquires the lock for the current thread. If the lock is already held by another thread, 
 *   the current thread waits until the lock is available.
 * - `lock.unlock()`: Releases the lock, allowing other waiting threads to acquire it.
 * - `finally` block: Ensures that the lock is always released, even if an exception is thrown.
 * 
 * Deadlock Scenario:
 * - A deadlock can occur if a thread holds a lock and attempts to acquire another lock that's already held by a different thread, 
 *   causing both threads to wait indefinitely. In this example, there's no deadlock because the same thread is acquiring the lock
 *   in both `outerMethod()` and `innerMethod()`.
 * 
 * Use Cases for Locks:
 * - `ReentrantLock` is useful when you need advanced locking features (like tryLock, fairness, etc.).
 * - It provides more flexibility compared to the `synchronized` keyword, but requires careful handling of 
 *   acquiring and releasing locks to avoid deadlocks.
 */
public class ReentrantLockExample {
    
    // Create an instance of ReentrantLock
    private final Lock lock = new ReentrantLock();

    /**
     * outerMethod:
     * - This method acquires the lock and then calls innerMethod(), which also acquires the lock.
     * - Since `ReentrantLock` allows a thread to re-acquire the same lock, it doesn't cause a deadlock here.
     * - The `finally` block ensures that the lock is always released, even if an exception occurs.
     */
    public void outerMethod(){
        lock.lock();  // Acquire the lock
        try {
            System.out.println("Inside OuterMethod..");
            
            // Calling innerMethod() from within outerMethod()
            innerMethod();  // innerMethod will acquire the same lock again
        } finally {
            lock.unlock();  // Release the lock
        }
    }

    /**
     * innerMethod:
     * - This method is called by outerMethod(), and it tries to acquire the same lock.
     * - Since the same thread holds the lock, and ReentrantLock allows re-entry, 
     *   this does not cause any issue.
     * - After completing the operation, the lock is released.
     */
    public void innerMethod(){
        lock.lock();  // Acquire the lock again (re-entrant)
        try {
            System.out.println("Inside InnerMethod");
        } finally {
            lock.unlock();  // Release the lock
        }
    }

    /**
     * main method:
     * - The execution begins here.
     * - An instance of ReentrantLockExample is created and the outerMethod() is called.
     * - This triggers the lock mechanism and shows how a re-entrant lock works.
     */
    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        
        // Call outerMethod, which will in turn call innerMethod
        example.outerMethod();
    }
}
