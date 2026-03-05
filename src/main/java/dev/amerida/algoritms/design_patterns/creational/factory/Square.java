package dev.amerida.algoritms.design_patterns.creational.factory;

public final class Square implements Shape {

    @Override
    public void draw() {
        IO.println("Inside Square::draw() method.");
    }
}
