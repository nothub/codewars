package lol.hub.codewars.java_functional_programming_part_2_multiline_functions;

public class Triangle {
    public final int height;
    public final int base;
    private double area;

    public Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    public void setArea(double a) {
        area = a;
    }
    public double getArea() {
        return area;
    }
}
