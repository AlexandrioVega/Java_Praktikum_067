package kasus2;

//**********************************************************
// PaintThings.java
// Demonstrates polymorphism with various shapes and paint coverage.
//**********************************************************

public class PaintThings {
    public static void main(String[] args) {
        final double COVERAGE = 350; 
        Paint paint = new Paint(COVERAGE);

        Rectangle deck = new Rectangle(20, 35);  
        Sphere bigBall = new Sphere(15);          
        Cylinder tank = new Cylinder(10, 30);  

        double deckAmt, ballAmt, tankAmt;
        
        deckAmt = paint.amount(deck);
        ballAmt = paint.amount(bigBall);
        tankAmt = paint.amount(tank);

        System.out.println("\nAmount of paint needed:");
        System.out.printf("Deck: %.2f gallons\n", deckAmt);
        System.out.printf("Big Ball: %.2f gallons\n", ballAmt);
        System.out.printf("Tank: %.2f gallons\n", tankAmt);
    }
}
