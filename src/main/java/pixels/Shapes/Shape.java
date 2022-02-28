package pixels.Shapes;

import pixels.Foundation.Texture;

public abstract class Shape {

    protected int posX = 0;
    protected int posY = 0;
    protected int red, green, blue;
    public final BoundingBox boundingBox = new BoundingBox();

    public void setPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    protected void setPixel(int x, int y, int red, int green, int blue) {
        if (x < 0 || x >= Texture.x) return;
        if (y < 0 || y >= Texture.y) return;
        if (red < 0) red = 0;
        if (red > 255) red = 255;
        if (green < 0) green = 0;
        if (green > 255) green = 255;
        if (blue < 0) blue = 0;
        if (blue > 255) blue = 255;
        Texture.set_pixel(x,y,red,green,blue);
    }

    protected void getPixel(int x, int y, int[] red, int[] green, int[] blue) {
        if (x < 0 || x >= Texture.x) return;
        if (y < 0 || y >= Texture.y) return;
        Texture.get_pixel(x,y,red,green,blue);
    }

    public abstract void draw();

    public abstract void updateBoundingBox();
}
