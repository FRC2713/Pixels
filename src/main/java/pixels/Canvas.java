package pixels;

import pixels.Shapes.Rectangle;
import pixels.Shapes.Text;

import static org.lwjgl.glfw.GLFW.*;

public class Canvas<i> {

    private int x = 0;
    private int y = 0;
    private int mouseX;
    private int mouseY;
    private int mode = 2;
    private boolean pickup = false;
    private Rectangle rect = new Rectangle();
    private Rectangle rect2 = new Rectangle();
    private Rectangle rect3 = new Rectangle();
    private Text text = new Text();
    private Rectangle[] petals = new Rectangle[5];
    private Rectangle stem = new Rectangle();

    public void makePetals()
    {
        int baseX = 350;
        int baseY = 350;

        for (int i = 0; i < petals.length; i++)
        {
            petals[i] = new Rectangle();
            if (i == 0) petals[i].setPos(baseX,baseY+50);
            if (i == 1) petals[i].setPos(baseX-40,baseY-50);
            if (i == 2) petals[i].setPos(baseX+40, baseY-50);
            if (i == 3) petals[i].setPos(baseX-50, baseY+10);
            if (i == 4) petals[i].setPos(baseX+50, baseY+10);
            petals[i].setColor(160,0,252);
            petals[i].setWidth(50);
            petals[i].setHeight(50);
            petals[i].draw();
        }
    }
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

        if (button == GLFW_MOUSE_BUTTON_LEFT && action ==GLFW_PRESS) {
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

        rect3.setPos(350,350);
        rect3.setWidth(50);
        rect3.setHeight(50);
        rect3.updateBoundingBox();
        rect3.setColor(246,255,0);

        stem.setPos(350,200);
        stem.setWidth(50);
        stem.setHeight(150);
        stem.setColor(0,255,0);




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

        text.setText("Flower!!!!");
        if (!pickup) text.setPos(600, 600);
        text.setSize(4);
        text.setColor(0,0, 255);
        text.updateBoundingBox();

        stem.draw();
        text.draw();
        rect.draw();
        rect2.draw();
        rect3.draw();
        makePetals();
    }
}
