package pixels.Shapes;

import java.util.ArrayList;

public class BoundingBox {

    private int min_x = 0;
    private int max_x = 0;
    private int min_y = 0;
    private int max_y = 0;

    public interface doThisWhenCollide {
        public void doThis(Shape shape);
    }

    public void update(int min_x, int max_x, int min_y, int max_y) {
        this.min_x = min_x;
        this.max_x = max_x;
        this.min_y = min_y;
        this.max_y = max_y;
    }

    public boolean doesBoundingBoxCollideWith(Shape shape) {
        if (max_x < shape.boundingBox.min_x) return false;
        if (min_x > shape.boundingBox.max_x) return false;

        if (max_y < shape.boundingBox.min_y) return false;
        if (min_y > shape.boundingBox.max_y) return false;

        return true;
    }

    public Shape doesBoundingBoxCollideWith(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            if (doesBoundingBoxCollideWith(shape)) return shape;
        }
        return null;
    }

    public void whenBoundingBoxCollidesWith(Shape shape, doThisWhenCollide whenCollide) {
        if (doesBoundingBoxCollideWith(shape)) whenCollide.doThis(shape);
    }

    public void whenBoundingBoxCollidesWith(ArrayList<Shape> shapes, doThisWhenCollide whenCollide) {
        Shape shape = doesBoundingBoxCollideWith(shapes);
        if (shape != null) whenCollide.doThis(shape);
    }

    public int getMinX() {
        return min_x;
    }

    public int getMaxX() {
        return max_x;
    }

    public int getMinY() {
        return min_y;
    }

    public int getMaxY() {
        return max_y;
    }

}
