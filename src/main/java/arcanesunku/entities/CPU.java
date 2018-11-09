package arcanesunku.entities;

import arcanesunku.utils.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CPU extends Entity {

    private BufferedImage texture;
    private boolean moveDown = false;

    public CPU() {
        super("CPU");
        texture = Images.loadImage("paddle.png").getSubimage(16, 0, 16, 32);

        bounds.width = texture.getWidth() * 2;
        bounds.height = texture.getHeight() * 4;

        bounds.x = (640 - 52);
        bounds.y = 480 / 2 - 64;

        Images.tint(texture, new Color(5, 51, 18));
    }

    public void move() {
        if (bounds.y <= 0) {
            moveDown = true;
        } else if (bounds.y + (bounds.height) >= 490) {
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
//        g.setColor(Color.RED);
//        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.drawImage(texture, bounds.x - bounds.width / 2, bounds.y, texture.getWidth() * 4, texture.getHeight() * 4, null);
    }
}
