package kasus3;

//**********************************************************
// Strings.java
// Demonstrates sorting an array of String objects.
//**********************************************************

import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many words do you want to sort? ");
        int count = scan.nextInt();
        scan.nextLine();

        String[] words = new String[count];

        System.out.println("Enter the words:");
        for (int i = 0; i < count; i++)
            words[i] = scan.nextLine();

        Sorting.insertionSort(words);

        System.out.println("\nSorted words (descending):");
        for (String word : words)
            System.out.println(word);
    }
}
