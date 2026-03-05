package dev.amerida.algoritms.design_patterns.creational.factory;

public class ShapeFactory {
    public static Shape getShape(String shape) {
        return switch (shape.toLowerCase()) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            case "square" -> new Square();
            default -> throw new RuntimeException("Invalid shape");
        };
    }
}
