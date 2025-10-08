package kasus2;

//**********************************************************
// Paint.java
// Represents a type of paint that has a specific coverage value.
//**********************************************************

public class Paint {
    private double coverage; 

    public Paint(double coverage) {
        this.coverage = coverage;
    }

    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        return s.area() / coverage;
    }
}
