package kasus3;

//**********************************************************
// Salesperson.java
// Represents a salesperson with a first name, last name, and total sales.
//**********************************************************

public class Salesperson implements Comparable<Salesperson> {
    private String firstName, lastName;
    private int totalSales;

    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    public String toString() {
        return lastName + ", " + firstName + ":\t" + totalSales;
    }

    public int getSales() {
        return totalSales;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int compareTo(Salesperson other) {
        if (this.totalSales < other.totalSales)
            return -1;
        else if (this.totalSales > other.totalSales)
            return 1;
        else
            return other.lastName.compareTo(this.lastName);
    }
}
