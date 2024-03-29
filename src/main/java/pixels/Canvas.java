package pixels;

import pixels.Shapes.Rectangle;
import pixels.Shapes.Text;

import static org.lwjgl.glfw.GLFW.*;

public class Canvas {

    private int x = 0;
    private int y = 0;
    private int mouseX;
    private int mouseY;
    private int mode = 2;
    private boolean pickup = false;
    private Rectangle rect = new Rectangle();
    private Rectangle rect2 = new Rectangle();
    private Text text = new Text();

    public void getKey(int key, int action) {
        if (key == GLFW_KEY_W) {
            y += 10;
        }

        if (key == GLFW_KEY_S) {
            y -= 10;
        }

        if (key == GLFW_KEY_D) {
            x += 10;
        }

        if (key == GLFW_KEY_A) {
            x -= 10;
        }
    }

    public void getMousePos(int posX, int posY) {
        mouseX = posX;
        mouseY = posY;
    }

    public void getMouseButton(int button, int action) {
        if (button == GLFW_MOUSE_BUTTON_RIGHT && action == GLFW_RELEASE) {
            mode += 1;
        }

        if (button == GLFW_MOUSE_BUTTON_LEFT && action == GLFW_PRESS) {
            pickup = true;
        } else {
            pickup = false;
        }

        if (mode > 3) mode = 1;
    }

    public void draw() {
        rect.setPos(x, y);
        rect.setWidth(50);
        rect.setHeight(50);
        rect.updateBoundingBox();
        rect.setColor(0, 0, 255);

        rect2.setPos(mouseX, mouseY);
        rect2.setWidth(50);
        rect2.setHeight(50);
        rect2.updateBoundingBox();

        if (mode == 1) rect2.setColor(255,0,0);
        if (mode == 2) rect2.setColor(0,255,0);
        if (mode == 3) rect2.setColor(0,0,255);

        rect2.boundingBox.whenBoundingBoxCollidesWith(rect, (shape) -> {
            if (pickup) {
                x = mouseX - 25;
                y = mouseY - 25;
                shape.setPos(x, y);
                shape.updateBoundingBox();
            }
        });

        rect2.boundingBox.whenBoundingBoxCollidesWith(text, (shape) -> {
            if (pickup) {
                shape.setPos(mouseX - 25, mouseY - 25);
                shape.updateBoundingBox();
            }
        });

        text.setText("Hello World!!!!");
        if (!pickup) text.setPos(600, 600);
        text.setSize(4);
        text.setColor(0,0, 255);
        text.updateBoundingBox();

        text.draw();
        rect.draw();
        rect2.draw();
    }
}
