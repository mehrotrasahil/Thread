package threadSafeCollection;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeMapExample {

    private static final ConcurrentHashMap<String, Integer> userScores = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // Initializing the map with some user scores
        userScores.put("User1", 10);
        userScores.put("User2", 20);
        userScores.put("User3", 30);

        // Creating threads that update user scores
        Thread user1Thread = new Thread(() -> updateScore("User1", 5));
        Thread user2Thread = new Thread(() -> updateScore("User2", 3));
        Thread user3Thread = new Thread(() -> updateScore("User3", 7));

        // Starting the threads
        user1Thread.start();
        user2Thread.start();
        user3Thread.start();

        try {
            // Wait for all threads to finish
            user1Thread.join();
            user2Thread.join();
            user3Thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        // Display final scores
        System.out.println("Final User Scores: " + userScores);
    }

    // Method to update user score
    private static void updateScore(String user, int increment) {
        userScores.computeIfPresent(user, (key, value) -> value + increment);
        System.out.println(user + " updated their score to: " + userScores.get(user));
    }
    
}
