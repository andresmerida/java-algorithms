package dev.amerida.algoritms.design_patterns.creational.factory;

import java.util.Calendar;

/**
 * Factory pattern is one of the most used design patterns in Java.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * <<p/>
 * In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.
 */
public class FactoryPatternDemo {
    static void main() {
        Shape shape = ShapeFactory.getShape("Circle");
        shape.draw();

        Shape square = ShapeFactory.getShape("Square");
        square.draw();

        Shape rectangle = ShapeFactory.getShape("Rectangle");
        rectangle.draw();

        // Now lets see JDK factory use cases
        Calendar calendar = Calendar.getInstance(); // instance a Calendar with default time zone (local time)
        IO.println(calendar.toString());
        IO.println();

        // Wrapper Classes (Integer, Boolean, etc) the valueOf() method is used to create an object of the class.
        Integer integer = Integer.valueOf("10");
        IO.println(integer);
        Boolean bool = Boolean.valueOf("true");
        IO.println(bool);
        IO.println();
    }
}
