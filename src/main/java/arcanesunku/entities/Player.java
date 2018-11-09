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
        texture = Images.loadImage("paddle.png").getSubimage(0, 0, 16, 32);

        bounds.width = texture.getWidth() * 2;
        bounds.height = texture.getHeight() * 4;

        bounds.x = 32 + bounds.width;
        bounds.y = 480 / 2 - 64;

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
        } else if (bounds.y + bounds.height >= 490) {
            bounds.y = 490 - bounds.height;
        }
    }

    @Override
    public void render(Graphics g) {
//        g.setColor(Color.RED);
//        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.drawImage(texture, bounds.x - bounds.width / 2, bounds.y, texture.getWidth() * 4, texture.getHeight() * 4, null);
    }
}
