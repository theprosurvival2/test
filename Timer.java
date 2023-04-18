package lab11;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Timer {
    public static void main(String[] args) {
        timer();
    }

    public static void timer() {
        Random rng = new Random();
        double[] arr = new double[10];
        double[] collisionCount = new double[10];
        double[] countArr = new double[10];
        int count = 0;

        // Do 10000 lookups and use the average running time
        long timesToLoop = 10000;

        // For each problem size n . . .
        for (int n = 10000; n <= 100000; n += 10000) {

            // Create hash table and put elements
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

            long startTime, midpointTime, stopTime;

            // First, spin computing stuff until one second has gone by
            // This allows this thread to stabilize
            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            // Now, run the test
            startTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                for (int j = 0; j < n; j++)
                    pq.add(rng.nextInt());
                pq.clear();
            }

            midpointTime = System.nanoTime();

            // Run a loop to capture the cost of running the "timesToLoop" loop
            for (int i = 0; i < timesToLoop; i++) { // empty block

            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and doing the insertion
            // Average it over the number of runs
            double averageTime = (((midpointTime - startTime)- (stopTime - midpointTime)) /
                    (double) timesToLoop);

            arr[count] = averageTime;
            countArr[count] = n;

            count++;

            System.out.println(n + "\t" + averageTime);
        }

        System.out.println("Average Time: " + Arrays.toString(arr));
        System.out.println("");
        System.out.println("Count: " + Arrays.toString(countArr));
        System.out.println("Collision: " + Arrays.toString(collisionCount));
    }
}
