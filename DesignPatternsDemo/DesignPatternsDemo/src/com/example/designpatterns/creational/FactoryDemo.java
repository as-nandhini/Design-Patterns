package com.example.designpatterns.creational;
interface Shape {
    void draw();
}
class Circle implements Shape {
    @Override
    public void draw() { System.out.println("Drawing a Circle."); }
}
class Rectangle implements Shape {
    @Override
    public void draw() { System.out.println("Drawing a Rectangle."); }
}
class Square implements Shape {
    @Override
    public void draw() { System.out.println("Drawing a Square."); }
}
class ShapeFactory {
    public Shape getShape(String type) {
        if (type == null) return null;
        switch (type.toLowerCase()) {
            case "circle": return new Circle();
            case "rectangle": return new Rectangle();
            case "square": return new Square();
            default: return null;
        }
    }
}
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape s1 = factory.getShape("circle");
        if (s1 != null) s1.draw();
        Shape s2 = factory.getShape("rectangle");
        if (s2 != null) s2.draw();
        Shape s3 = factory.getShape("square");
        if (s3 != null) s3.draw();
    }
}