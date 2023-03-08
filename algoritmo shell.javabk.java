package com.sample;
import java.util.Random;

public class MainClass {
	public static void main(String[] args) {
        // Generate 1000 random numbers between -1000 and 1000
        Random rand = new Random();
        int[] numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = rand.nextInt(2001) - 1000;
        }

        // Find the 10 numbers that are repeated most frequently
        int[] frequency = new int[2001];
        for (int i = 0; i < 1000; i++) {
            int currentNumber = numbers[i];
            frequency[currentNumber + 1000]++;
        }
        int[] mostFrequent = new int[10];
        int[] mostFrequentCount = new int[10];
        for (int i = 0; i < 10; i++) {
            mostFrequent[i] = -1001;
            mostFrequentCount[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < 2001; i++) {
            int currentNumber = i - 1000;
            int currentCount = frequency[i];
            for (int j = 0; j < 10; j++) {
                if (currentCount > mostFrequentCount[j]) {
                    for (int k = 9; k > j; k--) {
                        mostFrequent[k] = mostFrequent[k - 1];
                        mostFrequentCount[k] = mostFrequentCount[k - 1];
                    }
                    mostFrequent[j] = currentNumber;
                    mostFrequentCount[j] = currentCount;
                    break;
                }
            }
        }

        // Find the 10 numbers that are repeated least frequently
        int[] leastFrequent = new int[10];
        int[] leastFrequentCount = new int[10];
        for (int i = 0; i < 10; i++) {
            leastFrequent[i] = -1001;
            leastFrequentCount[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < 2001; i++) {
            int currentNumber = i - 1000;
            int currentCount = frequency[i];
            for (int j = 0; j < 10; j++) {
                if (currentCount < leastFrequentCount[j]) {
                    for (int k = 9; k > j; k--) {
                        leastFrequent[k] = leastFrequent[k - 1];
                        leastFrequentCount[k] = leastFrequentCount[k - 1];
                    }
                    leastFrequent[j] = currentNumber;
                    leastFrequentCount[j] = currentCount;
                    break;
                }
            }
        }

        // Find the maximum and minimum numbers
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 1000; i++) {
            int currentNumber = numbers[i];
            if (currentNumber > max) {
                max = currentNumber;
            }
            if (currentNumber < min) {
                min = currentNumber;
            }
        }

        // Count the number of even and odd numbers
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < 1000; i++) {
            int currentNumber = numbers[i];
            if (currentNumber % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Count the number of prime and non-prime numbers
        int primeCount = 0;
        int nonPrimeCount = 0;
        for (int i = 0; i < 1000; i++) {
            int currentNumber = numbers[i];
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(currentNumber); j++) {
                if (currentNumber % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && currentNumber > 1) {
                primeCount++;
            } else {
                nonPrimeCount++;
            }
        }

        // Sort the numbers using the bubble sort algorithm
        for (int i = 0; i < 1000 - 1; i++) {
            for (int j = 0; j < 1000 - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        // Print the results
        System.out.println("10 numbers repeated with the most frequency:");
        for (int i = 0; i < 10; i++) {
            System.out.println(mostFrequent[i] + ": " + mostFrequentCount[i]);
        }
        System.out.println("\n10 numbers repeated with the least frequency:");
        for (int i = 0; i < 10; i++) {
            System.out.println(leastFrequent[i] + ": " + leastFrequentCount[i]);
        }
        System.out.println("\nMax number: " + max);
        System.out.println("Min number: " + min);
        System.out.println("\nNumber of even numbers: " + evenCount);
        System.out.println("Number of odd numbers: " + oddCount);
        System.out.println("\nNumber of prime numbers: " + primeCount);
        System.out.println("Number of non-prime numbers: " + nonPrimeCount);
    }
}