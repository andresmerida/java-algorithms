package dev.amerida.algoritms.design_patterns.creational.factory;

public non-sealed class Rectangle implements Shape {
    @Override
    public void draw() {
        IO.println("Inside Rectangle::draw() method.");
    }
}
