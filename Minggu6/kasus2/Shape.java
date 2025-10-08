package kasus2;

//**********************************************************
// Shape.java
// Abstract parent class for all shapes.
//**********************************************************

public abstract class Shape {
    protected String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public String toString() {
        return shapeName;
    }

    public abstract double area();
}
