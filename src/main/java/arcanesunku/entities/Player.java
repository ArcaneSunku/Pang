package arcanesunku.entities;

import arcanesunku.InputHandler;
import arcanesunku.utils.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private BufferedImage texture;

    public Player() {
        super("Player");

        bounds.x = 32;
        bounds.y = 480 / 2 - 64;

        texture = Images.loadImage("paddle.png").getSubimage(0, 0, 16, 32);
        Images.tint(texture, new Color(205, 19, 255));
    }

    @Override
    public void update() {
        if (InputHandler.isKeyPressed(KeyEvent.VK_W) || InputHandler.isKeyPressed(KeyEvent.VK_UP)) {
            bounds.y -= 4;
        } else if (InputHandler.isKeyPressed(KeyEvent.VK_S) || InputHandler.isKeyPressed(KeyEvent.VK_DOWN)) {
            bounds.y += 4;
        }

        if (bounds.y <= 0) {
            bounds.y = 0;
        } else if (bounds.y + (bounds.height * 4) >= 490) {
            bounds.y = 490 - (bounds.height * 4);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(bounds.x, bounds.y, bounds.width * 2, bounds.height * 4);
        g.drawImage(texture, bounds.x, bounds.y, bounds.width * 2, bounds.height * 4, null);
    }
}
