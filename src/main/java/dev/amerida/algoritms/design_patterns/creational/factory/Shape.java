package dev.amerida.algoritms.design_patterns.creational.factory;

public sealed interface Shape permits Circle, Rectangle, Square {
    void draw();
}
