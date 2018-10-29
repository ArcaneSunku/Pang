package arcanesunku.entities;

import arcanesunku.utils.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CPU extends Entity {

    private BufferedImage texture;
    private boolean moveDown = false;

    public CPU() {
        super("CPU");

        bounds.x = (640 - 52) - bounds.width;
        bounds.y = 480 / 2 - 64;

        texture = Images.loadImage("paddle.png").getSubimage(16, 0, 16, 32);
        Images.tint(texture, new Color(5, 51, 18));
    }

    public void move() {
        if (bounds.y <= 0) {
            moveDown = true;
        } else if (bounds.y + (bounds.height * 4) >= 490) {
            moveDown = false;
        }

        if (moveDown) {
            bounds.y += 3;
        } else {
            bounds.y -= 3;
        }
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(bounds.x, bounds.y, bounds.width * 2, bounds.height * 4);
        g.drawImage(texture, bounds.x, bounds.y, bounds.width * 2, bounds.height * 4, null);
    }
}
