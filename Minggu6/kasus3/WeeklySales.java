package kasus3;

//**********************************************************
// WeeklySales.java
// Demonstrates sorting an array of Salesperson objects.
//**********************************************************

public class WeeklySales {
    public static void main(String[] args) {
        Salesperson[] salesStaff = {
            new Salesperson("John", "Smith", 3000),
            new Salesperson("Sue", "Walters", 6000),
            new Salesperson("Jane", "Doe", 4000),
            new Salesperson("Kim", "Howard", 4000),
            new Salesperson("Tom", "Wong", 3000),
            new Salesperson("Bill", "Li", 3000),
            new Salesperson("Bob", "Smith", 6000)
        };

        System.out.println("Before Sorting:\n");
        for (Salesperson s : salesStaff)
            System.out.println(s);
            
        Sorting.insertionSort(salesStaff);

        System.out.println("\nAfter Sorting (by sales descending, ties reversed alphabetically):\n");
        for (Salesperson s : salesStaff)
            System.out.println(s);
    }
}
