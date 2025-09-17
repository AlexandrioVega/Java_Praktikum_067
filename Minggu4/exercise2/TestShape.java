package exercise2;

public class TestShape {
    public static void main(String[] args) {
        // Test Shape
        Shape s1 = new Shape();
        Shape s2 = new Shape("blue", false);
        System.out.println(s1);
        System.out.println(s2);

        // Test Circle
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.5, "yellow", true);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea() + ", Perimeter: " + c1.getPerimeter());
        System.out.println(c2);
        System.out.println("Area: " + c2.getArea() + ", Perimeter: " + c2.getPerimeter());

        // Test Rectangle
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(2.0, 5.0, "black", false);
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea() + ", Perimeter: " + r1.getPerimeter());
        System.out.println(r2);
        System.out.println("Area: " + r2.getArea() + ", Perimeter: " + r2.getPerimeter());

        // Test Square
        Square sq1 = new Square();
        Square sq2 = new Square(4.0, "pink", true);
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea() + ", Perimeter: " + sq1.getPerimeter());
        System.out.println(sq2);
        System.out.println("Area: " + sq2.getArea() + ", Perimeter: " + sq2.getPerimeter());

        
        sq2.setWidth(7.0); 
        System.out.println("After setWidth(7.0): " + sq2);
        sq2.setLength(10.0);
        System.out.println("After setLength(10.0): " + sq2);
    }
}
