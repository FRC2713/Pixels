package pixels.Shapes;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw() {
        int i = 0;
        int j = 0;
        while (i < width) {
            j = 0;
            while (j < height) {
                 setPixel(i + posX, j + posY, red, green, blue);
                j++;
            }
            i++;
        }
    }

    @Override
    public void updateBoundingBox() {
        boundingBox.update(posX,posX+width, posY,posY+height);
    }
}
