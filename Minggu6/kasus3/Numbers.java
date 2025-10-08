package kasus3;

//**********************************************************
// Numbers.java
// Demonstrates sorting an array of Integer objects.
//**********************************************************

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many numbers do you want to sort? ");
        int count = scan.nextInt();

        Integer[] numbers = new Integer[count];

        System.out.println("Enter the numbers:");
        for (int i = 0; i < count; i++)
            numbers[i] = scan.nextInt();

        Sorting.insertionSort(numbers);

        System.out.println("\nSorted numbers (descending):");
        for (Integer num : numbers)
            System.out.print(num + " ");

        System.out.println();
    }
}
