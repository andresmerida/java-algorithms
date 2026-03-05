package dev.amerida.algoritms.design_patterns.creational.factory;

public final class Circle implements Shape {
    @Override
    public void draw() {
        IO.println("Inside Circle::draw() method.");
    }
}
